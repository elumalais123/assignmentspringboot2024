package com.cts.auth.service;

import com.cts.auth.dto.JwtAuthenticationResponse;
import com.cts.auth.dto.RefreshTokenRequest;
import com.cts.auth.dto.SignInRequest;
import com.cts.auth.dto.SignUpRequest;
import com.cts.auth.entity.User;
import com.cts.auth.enums.Role;
import com.cts.auth.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl {

	private  UserRepository userRepository;
	private  PasswordEncoder passwordEncoder;
	private  AuthenticationManager authenticationManager;
	private  JWTServiceImpl jwtService;

	public User signUp(SignUpRequest signUpRequest) {
		User user = new User();
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		user.setRole(Role.USER);
		return userRepository.save(user);
	}

	public JwtAuthenticationResponse signIn(SignInRequest signInRequest) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));

		var user = userRepository.findByEmail(signInRequest.getEmail())
				.orElseThrow(() -> new IllegalArgumentException("Invalid Email id"));
		var jwt = jwtService.generateToken(user);
		var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

		JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
		jwtAuthenticationResponse.setToken(jwt);
		jwtAuthenticationResponse.setRefreshToken(refreshToken);

		return jwtAuthenticationResponse;
	}

	public User adminSignUp(SignUpRequest signUpRequest) {
		User user = new User();
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		user.setRole(Role.ADMIN);
		return userRepository.save(user);
	}

	public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
		String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
		User user = userRepository.findByEmail(userEmail).orElseThrow();
		if (jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
			var jwt = jwtService.generateToken(user);

			JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
			jwtAuthenticationResponse.setToken(jwt);
			jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());

			return jwtAuthenticationResponse;
		}
		return null;
	}
}
