Feature: Language Footer Navigation
    As a user
    To navigate through the language options
    I want to be able to click on language flags in the footer

    Scenario: The page loads in French by default
        Given I navigate to brute.eternaltwin.org
        Then the page should be displayed in English

    Scenario Outline: I can access the subpages through the language flags in the footer
        Given I navigate to brute.eternaltwin.org
        When I push on the flag languaje <lng>
        Then the page shoulb be display in the correct title <tabtitle>
        Examples:
            | lng | tabtitle    |
            | fr  | LaBrute     |
            | de  | MeinBrutalo |
            | es  | ElBruto     |
            | ru  | МойБрутал   |
            | pt  | MeuBruto    |