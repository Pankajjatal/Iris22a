Feature: This feature discribes different parameterization abvailable in cucumber
#
  #Scenario: How to parameterize numbric value
    #Given I have two numbers 15 & 63
    #When I add them
    #Then Print the result
#
  #Scenario: How to parameterize floating numbers
    #Given I have two float numbers 3.23 and 5.1
    #Then Display numbers
#
  #Scenario: How to parameterize string
    #Given I have fruite "apple
    #Then Display it's "color"

  Scenario: How to parameterize list
    Given I have following states <states>
      | Maharashtra    |35| MH |
      | Gujrat         |33| GJ |
      | West Bengal    |23| WB |
      | Tamil Nadu     |38| TN |
      | Andhra Pradesh |26| AP |
      | Telangana      |31| TS |
      | Chattisgarh    |33| CH |
    Then Display all city state names
    
    Scenario Outline: How to perform data driven testing
    #Given I have <num1> and <num2>
    Given I have <row_num>
    When I add them
    Then print if their addition is prime
    
    Examples:
    |num1|num2|
    |11|12|
    |8|3|
    |12|14|
    |5|6|
    |4|7|
    |21|23|
    |32|15|
    
    Examples:
    |row_num|
    |1|
    |2|
    |3|
    |4|
    |5|
    |6|
    |7|
    |8|
    |9|
    |10| 