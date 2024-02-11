package com.example.demotest;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayWithLocaleTest {

	@Test
	public void test() {


		Locale forLanguageTag = Locale.forLanguageTag("fr-FR");

		Locale newLocale = new Locale(Locale.FRANCE.toLanguageTag());

		//assertThat(forLanguageTag).isEqualTo(newLocale);

		System.out.println(forLanguageTag);
		System.out.println(forLanguageTag.toString());
		System.out.println(forLanguageTag.toLanguageTag());

	}


}
