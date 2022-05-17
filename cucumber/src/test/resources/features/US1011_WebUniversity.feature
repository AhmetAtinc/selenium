@WebU
Feature: US1011 WebUniversity Window Handle

  Scenario Outline: TC16 Reusable Methods ile window Handle Testi

    Given kullanici "WebUniversityUrl" sayfasina gider
    And Login Portal'a  kadar asagi iner
    And Login Portal'a tiklar
    Then  acilan Diger window'a gecin
    And "<username>" ve  "<password>" kutularina deger yazar
    And WebUniversity login butonuna basar
    And Popup'ta cikan yazinin "validation failed" oldugunu test eder
    Then Ok diyerek Popup'i kapatir
    And Ilk sayfaya geri doner
    And Ilk sayfaya donuldugunu test eder

Examples:
|username|password|
|mustafa|donat|
    

