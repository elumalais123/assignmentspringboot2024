package com.stackroute.streams;

import java.util.Objects;

public class Country {
    String code;
    String name;

    public String getCountryCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void setCountryCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country() {
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

	@Override
	public int hashCode() {
		return Objects.hash(code, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(code, other.code) && Objects.equals(name, other.name);
	}
    
}
