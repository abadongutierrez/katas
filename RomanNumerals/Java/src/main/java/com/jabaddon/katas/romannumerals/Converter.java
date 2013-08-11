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

	public Integer toInteger(String romanNumber) {
		System.out.println("### >> toInteger(romanNumber: [" + romanNumber + "]) ###");
		if (romanNumber.length() == 0) {
			return 0;
		}
		String rm = new String(romanNumber);
		Integer units = 1;
		Integer number = 0;
		Integer result = 0;
		while (rm.length() > 0) {			
			if (units == 1) {
				result = process1s(rm);												
			}
			else if (units == 10) {
				if (process1s(rm) > 0) throw new RuntimeException();
				result = process10s(rm);
			}
			else if (units == 100) {
				if (process10s(rm) + process1s(rm) > 0) throw new RuntimeException();
				result = process100s(rm);
			}
			else if (units == 1000) {
				if (process100s(rm) + process10s(rm) + process1s(rm) > 0) throw new RuntimeException();
				result = process1000s(rm);
			}

			units *= 10;						
			number += result;
			if (result > 0) {
				int sbs = rm.length() - toRomanNumeral(result).length();
				rm = rm.substring(0, sbs);
			}
			result = 0;
		}
		System.out.println("### << toInteger(romanNumber: [" + romanNumber + "]): [" + number + "] ###");
		return number;
	}

	private Integer process1s(String romanNumber) {
		System.out.println("### >> process1s(romanNumber: [" + romanNumber + "]) ###");
		int number = 0;
		if (romanNumber.endsWith("VIII")) number = 8;
		else if (romanNumber.endsWith("VII")) number = 7;
		else if (romanNumber.endsWith("VI")) number = 6;
		else if (romanNumber.endsWith("IV")) number = 4;
		else if (romanNumber.endsWith("V")) number = 5;
		else if (romanNumber.endsWith("III")) number = 3;
		else if (romanNumber.endsWith("II")) number = 2;
		else if (romanNumber.endsWith("I")) number = 1;
		else if (romanNumber.endsWith("IX")) number = 9;
		System.out.println("### >> process1s(romanNumber: [" + romanNumber + "]): [" + number + "] ###");
		return number;
	}

	private Integer process10s(String romanNumber) {
		System.out.println("### >> process10s(romanNumber: [" + romanNumber + "]) ###");
		int number = 0;
		if (romanNumber.endsWith("LXXX")) number = 80;
		else if (romanNumber.endsWith("LXX")) number = 70;
		else if (romanNumber.endsWith("LX")) number = 60;
		else if (romanNumber.endsWith("XL")) number = 40;
		else if (romanNumber.endsWith("L")) number = 50;
		else if (romanNumber.endsWith("XXX")) number = 30;
		else if (romanNumber.endsWith("XX")) number = 20;
		else if (romanNumber.endsWith("X")) number = 10;
		else if (romanNumber.endsWith("XC")) number = 90;
		System.out.println("### >> process10s(romanNumber: [" + romanNumber + "]): [" + number + "] ###");
		return number;
	}

	private Integer process100s(String romanNumber) {
		System.out.println("### >> process100s(romanNumber: [" + romanNumber + "]) ###");
		int number = 0;
		if (romanNumber.endsWith("DCCC")) number = 800;
		else if (romanNumber.endsWith("DCC")) number = 700;
		else if (romanNumber.endsWith("DC")) number = 600;
		else if (romanNumber.endsWith("CD")) number = 400;
		else if (romanNumber.endsWith("D")) number = 500;
		else if (romanNumber.endsWith("CCC")) number = 300;
		else if (romanNumber.endsWith("CC")) number = 200;
		else if (romanNumber.endsWith("C")) number = 100;
		else if (romanNumber.endsWith("CM")) number = 900;
		System.out.println("### >> process100s(romanNumber: [" + romanNumber + "]): [" + number + "] ###");
		return number;
	}

	private Integer process1000s(String romanNumber) {
		System.out.println("### >> process100s(romanNumber: [" + romanNumber + "]) ###");
		int number = 0;
		if (romanNumber.endsWith("MMM")) number = 3000;
		else if (romanNumber.endsWith("MM")) number = 2000;
		else if (romanNumber.endsWith("M")) number = 1000;
		else throw new RuntimeException("Not supported");
		System.out.println("### >> process100s(romanNumber: [" + romanNumber + "]): [" + number + "] ###");
		return number;
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