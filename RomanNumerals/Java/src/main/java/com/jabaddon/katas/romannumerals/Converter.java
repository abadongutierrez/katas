package com.jabaddon.katas.romannumerals;

public class Converter {
	public String toRomanNumeral(Integer number) {
		Integer i1;
		if (number == 0) {
			return "";
		}
		if (number.toString().length() == 1) {
			return convertUnits(number);
		}
		if (number.toString().length() == 2) {
			return convertTenths(i1 = ((int) (number / 10))) +
				toRomanNumeral(number - i1 * 10);
		}
		if (number.toString().length() == 3) {
			return convertHundredths(i1 = ((int) (number / 100))) + 
				toRomanNumeral(number - i1 * 100);
		}
		if (number.toString().length() == 4) {
			return convertThousandths(i1 = ((int) (number / 1000))) + 
				toRomanNumeral(number - i1 * 1000);
		}
		return "Unknown";
	}

	private String convertUnits(Integer number) {
		if (number == 1) return "I";
		if (number == 2) return "II";
		if (number == 3) return "III";
		if (number == 4) return "IV";
		if (number == 5) return "V";
		if (number == 6) return "VI";
		if (number == 7) return "VII";
		if (number == 8) return "VIII";
		if (number == 9) return "IX";
		return "";
		//throw new RuntimeException("Number [" + number + "] is not a unit");
	}

	private String convertTenths(Integer number) {
		if (number == 1) return "X";
		if (number == 2) return "XX";
		if (number == 3) return "XXX";
		if (number == 4) return "XL";
		if (number == 5) return "L";
		if (number == 6) return "LX";
		if (number == 7) return "LXX";
		if (number == 8) return "LXXX";
		if (number == 9) return "XC";
		return "";
		//throw new RuntimeException("Number [" + number + "] is not a Tenths");
	}

	private String convertHundredths(Integer number) {
		if (number == 1) return "C";
		if (number == 2) return "CC";
		if (number == 3) return "CCC";
		if (number == 4) return "CD";
		if (number == 5) return "D";
		if (number == 6) return "DC";
		if (number == 7) return "DCC";
		if (number == 8) return "DCCC";
		if (number == 9) return "CM";
		return "";
		//throw new RuntimeException("Number [" + number + "] is not a Hundredths");
	}

	private String convertThousandths(Integer number) {
		if (number == 1) return "M";
		if (number == 2) return "MM";
		if (number == 3) return "MMM";		
		return "";
		//throw new RuntimeException("Number [" + number + "] is not a Hundredths");
	}
}