package com.stackroute.streams;

import java.util.Objects;

public class Batsman implements Comparable<Batsman>{
    String name;
    int matchesPlayed;
    int totalRuns;
    int highestScore;
    Country country;
    
    public Batsman() {
		// TODO Auto-generated constructor stub
	}

	public Batsman(String name, int matchesPlayed, int totalRuns, int highestScore, Country country) {
		super();
		this.name = name;
		this.matchesPlayed = matchesPlayed;
		this.totalRuns = totalRuns;
		this.highestScore = highestScore;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public int getTotalRuns() {
		return totalRuns;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}

	public int getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Batsman [name=" + name + ", matchesPlayed=" + matchesPlayed + ", totalRuns=" + totalRuns
				+ ", highestScore=" + highestScore + ", country=" + country + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, highestScore, matchesPlayed, name, totalRuns);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Batsman other = (Batsman) obj;
		return Objects.equals(country, other.country) && highestScore == other.highestScore
				&& matchesPlayed == other.matchesPlayed && Objects.equals(name, other.name)
				&& totalRuns == other.totalRuns;
	}
    
	@Override
	public int compareTo(Batsman o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}
}
