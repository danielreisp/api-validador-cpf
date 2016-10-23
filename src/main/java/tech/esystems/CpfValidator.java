package tech.esystems;

/*******************************************************************************
 * Copyright © 2016 Victor Soares (www.e-systems.tech) All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice, this
 *   list of conditions and the following disclaimer in the documentation and/or
 *   other materials provided with the distribution.
 * * Neither the name of “E-SYSTEMS TECH, LLC” nor the names of its contributors may be used to
 *   endorse or promote products derived from this software without specific prior
 *   written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS “AS IS” AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *******************************************************************************/
 import java.util.stream.IntStream;

/**
 * CPF (Brazilian SSN) validator.
 *
 */
public class CpfValidator {

	private static final int CPF_SIZE = 11;

	public static boolean isValidCPF(String cpf) {
		if ((cpf == null) || !cpf.matches("^(\\d){11}$") || cpf.matches("^(\\d)\\1+{11}$"))
			return false;

		int[] digits = cpf.chars().map(c -> c - '0').toArray();

		int digitsValidator = calculateDigitsValidator(digits, 9);

		if (digitsValidator != digits[9])
			return false;

		digitsValidator = calculateDigitsValidator(digits, 10);

		return (digitsValidator == digits[10]);
	}

	private static int calculateDigitsValidator(int[] cpf, int endIndex) {

		int digit = IntStream.range(0,endIndex).map(i -> cpf[i] * (endIndex+1-i)).sum();
		digit = CPF_SIZE - (digit % 11);
		return (digit > 9) ? 0 : digit;
	}
}
