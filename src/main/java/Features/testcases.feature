Feature: Powerus
    Scenario Outline: "<testCaseTitle>"
        Given User is on main page
        When User wants to see "<itemType>" list
        And User selects card with "<itemTitle>" title
       	And User adds item to favorites
        Then User finds added to favorite confirmation
        And User sees page "<itemTitle>" title
        When User clicks back
        When User go to favorites page
        When User wants to see "<itemType>" list
				Then User find "<itemCount>" items
				And User selects card with "<itemTitle>" title
				And User sees page "<itemTitle>" title
				And User removes item from favorites
				Then User finds removed from favorite confirmation
				
        Examples:
            | testCaseTitle 				|itemType| itemTitle                   | itemCount|
            |	Add Favorite movie		|movie		| Puss in Boots: The Last Wish| 1|
            |	Add Favorite tvshow		|tv      | The Last of Us| 1|