package com.jabaddon.katas.romannumerals;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class RomanNumberToIntegerTest {
	private Converter converter;

	@Before
	public void setup() {
		converter = new Converter();
	}

	@Test
	public void convert_1s() {
		assertThat(converter.toInteger("I"), is(1));
		assertThat(converter.toInteger("II"), is(2));
		assertThat(converter.toInteger("III"), is(3));
		assertThat(converter.toInteger("IV"), is(4));
		assertThat(converter.toInteger("V"), is(5));
		assertThat(converter.toInteger("VI"), is(6));
		assertThat(converter.toInteger("VII"), is(7));
		assertThat(converter.toInteger("VIII"), is(8));
		assertThat(converter.toInteger("IX"), is(9));
	}

	@Test
	public void convert_10s() {
		assertThat(converter.toInteger("X"), is(10));
		assertThat(converter.toInteger("XX"), is(20));
		assertThat(converter.toInteger("XXX"), is(30));
		assertThat(converter.toInteger("XL"), is(40));
		assertThat(converter.toInteger("L"), is(50));
		assertThat(converter.toInteger("LX"), is(60));
		assertThat(converter.toInteger("LXX"), is(70));
		assertThat(converter.toInteger("LXXX"), is(80));
		assertThat(converter.toInteger("XC"), is(90));
	}

	@Test
	public void convert_100s() {
		assertThat(converter.toInteger("C"), is(100));
		assertThat(converter.toInteger("CC"), is(200));
		assertThat(converter.toInteger("CCC"), is(300));
		assertThat(converter.toInteger("CD"), is(400));
		assertThat(converter.toInteger("D"), is(500));
		assertThat(converter.toInteger("DC"), is(600));
		assertThat(converter.toInteger("DCC"), is(700));
		assertThat(converter.toInteger("DCCC"), is(800));
		assertThat(converter.toInteger("CM"), is(900));
	}

	@Test
	public void convert_1000s() {
		assertThat(converter.toInteger("M"), is(1000));
		assertThat(converter.toInteger("MM"), is(2000));
		assertThat(converter.toInteger("MMM"), is(3000));
	}

	@Test
	public void convert_random() {
		assertThat(converter.toInteger("MI"), is(1001));
		assertThat(converter.toInteger("MV"), is(1005));
		assertThat(converter.toInteger("MLXXI"), is(1071));
		assertThat(converter.toInteger("MC"), is(1100));
		assertThat(converter.toInteger("MMV"), is(2005));
		assertThat(converter.toInteger("MMMV"), is(3005));
	}

	@Test(expected = RuntimeException.class)
	public void convert_weird() {
		assertThat(converter.toInteger("VX"), is(-1));
		assertThat(converter.toInteger("XXXX"), is(-1));
		assertThat(converter.toInteger("MMMM"), is(-1));
	}
}