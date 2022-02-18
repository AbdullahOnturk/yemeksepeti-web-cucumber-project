Feature: Yemeksepeti login test
  Scenario: Yemeksepeti uygulaması açılır ve pozitif adımlarla login olunur.

    Given "https://www.yemeksepeti.com/" web sitesi açılır!!!!!!!!
    When "//*[text()='34']" xpath ine tıklanır.
    When "UserName" id alanına "testtest@test.com" yazılır.
    When "password" id alanına "Otomasyon.12" yazılır.
    When "ys-fastlogin-button" id sine tıklanır.
    Then "//span[text()='Online yemek veya market siparişleriniz için aşağıdan seçim yapabilirsiniz']" element alanında "Online yemek veya market siparişleriniz için aşağıdan seçim yapabilirsiniz" yazdığı kontrol edilir.
    When "//button[@class='modal-header-close']" xpath ine tıklanır.
    When "cboxClose" id sine tıklanır.