Feature: US1006 Negative login testi


  Scenario: TC09 yanlis username, dogru sifre ile giris yapilamaz

    Given kullanici "HMCUrl" sayfasina gider
    And login linkine tiklar
    Then kullanici adi olarak "HMCWrongUsername" girer
    And password olarak "HMCValidPassword" girer
    And login butonuna basar
    And giris yapilamadigini test eder
    And sayfayi kapatir

    Scenario: TC10 dogru username, yanlis sifre ile giris yapilamaz

      Given kullanici "HMCUrl" sayfasina gider
      Then login linkine tiklar
      And kullanici adi olarak "HMCValidUsername" girer
      And password olarak "HMCWrongPassword" girer
      Then login butonuna basar
      And giris yapilamadigini test eder
      And sayfayi kapatir


      Scenario: TC yanlis username ve yanlis sifre ile giris yapilamamaz

        Given kullanici "HMCUrl" sayfasina gider
        Then login linkine tiklar
        And kullanici adi olarak "HCMWrongUsername" girer
        And password olarak "HMCWrongPassword" girer
        Then login butonuna basar
        And giris yapilamadigini test eder
        And sayfayi kapatir