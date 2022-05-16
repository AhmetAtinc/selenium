Feature: US1010 HerokuAdd sayfasinda add butonu testi

  @Hero
  Scenario: TC!% sonradan gorunen elemanlar calismali

    Given kullanici "HerokuAddElementUrl" sayfasina gider
    When Add Element butonuna basar
    Then Delete butonu gorunur oluncaya kadar bekler
    And Delete butonunun gorundugunu test eder
    Then Delete butonuna basarak butonu siler
    And 5 saniye bekler
    And sayfayi kapatir
