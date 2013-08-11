package com.jabaddon.katas.romannumerals;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ConverterTest {

	private Converter converter;

	@Before
	public void setup() {
		converter = new Converter();
	}

	@Test
	public void convert_random() {
		assertThat(converter.toRomanNumeral(11), is("XI"));
		assertThat(converter.toRomanNumeral(25), is("XXV"));
		assertThat(converter.toRomanNumeral(35), is("XXXV"));
		assertThat(converter.toRomanNumeral(44), is("XLIV"));
		assertThat(converter.toRomanNumeral(55), is("LV"));
		assertThat(converter.toRomanNumeral(66), is("LXVI"));
		assertThat(converter.toRomanNumeral(67), is("LXVII"));
		assertThat(converter.toRomanNumeral(71), is("LXXI"));
		assertThat(converter.toRomanNumeral(88), is("LXXXVIII"));
		assertThat(converter.toRomanNumeral(92), is("XCII"));
		assertThat(converter.toRomanNumeral(192), is("CXCII"));
		assertThat(converter.toRomanNumeral(1192), is("MCXCII"));
		assertThat(converter.toRomanNumeral(1071), is("MLXXI"));
		assertThat(converter.toRomanNumeral(1990), is("MCMXC"));
		assertThat(converter.toRomanNumeral(2008), is("MMVIII"));
		assertThat(converter.toRomanNumeral(3999), is("MMMCMXCIX"));
	}
	
	@Test
	public void convert_Units() {
		assertThat(converter.toRomanNumeral(1), is("I"));
		assertThat(converter.toRomanNumeral(2), is("II"));
		assertThat(converter.toRomanNumeral(3), is("III"));
		assertThat(converter.toRomanNumeral(4), is("IV"));
		assertThat(converter.toRomanNumeral(5), is("V"));
		assertThat(converter.toRomanNumeral(6), is("VI"));
		assertThat(converter.toRomanNumeral(7), is("VII"));
		assertThat(converter.toRomanNumeral(8), is("VIII"));
		assertThat(converter.toRomanNumeral(9), is("IX"));
	}

	@Test
	public void convert_Tenths() {
		assertThat(converter.toRomanNumeral(10), is("X"));
		assertThat(converter.toRomanNumeral(20), is("XX"));
		assertThat(converter.toRomanNumeral(30), is("XXX"));
		assertThat(converter.toRomanNumeral(40), is("XL"));
		assertThat(converter.toRomanNumeral(50), is("L"));
		assertThat(converter.toRomanNumeral(60), is("LX"));
		assertThat(converter.toRomanNumeral(70), is("LXX"));
		assertThat(converter.toRomanNumeral(80), is("LXXX"));
		assertThat(converter.toRomanNumeral(90), is("XC"));
	}

	@Test
	public void convert_Hundredths() {
		assertThat(converter.toRomanNumeral(100), is("C"));
		assertThat(converter.toRomanNumeral(200), is("CC"));
		assertThat(converter.toRomanNumeral(300), is("CCC"));
		assertThat(converter.toRomanNumeral(400), is("CD"));
		assertThat(converter.toRomanNumeral(500), is("D"));
		assertThat(converter.toRomanNumeral(600), is("DC"));
		assertThat(converter.toRomanNumeral(700), is("DCC"));
		assertThat(converter.toRomanNumeral(800), is("DCCC"));
		assertThat(converter.toRomanNumeral(900), is("CM"));
	}

	@Test
	public void convert_Thousandths() {
		assertThat(converter.toRomanNumeral(1000), is("M"));
		assertThat(converter.toRomanNumeral(2000), is("MM"));
		assertThat(converter.toRomanNumeral(3000), is("MMM"));
	}
}