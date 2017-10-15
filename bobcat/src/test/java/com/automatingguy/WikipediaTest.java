package com.automatingguy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.google.inject.Inject;
import com.automatingguy.GuiceModule;
import com.automatingguy.pageobjects.WikipediaPage;
import com.automatingguy.pageobjects.DefinitionPage;

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class WikipediaTest {

  private static final String SEARCH_QUERY = "hello world";
  private static final String HEADING = "\"Hello, World!\" program";

  @Inject
  private WikipediaPage homePage;

  @Inject
  private DefinitionPage definitionPage;

  @Test
  public void wikipediaSearchTest() {
    homePage.open().getSearchComponent().searchForQuery(SEARCH_QUERY);
    assertThat(definitionPage.getHeading(), is(HEADING));
  }
}
