package org.hepsiburda;

import com.thoughtworks.gauge.Step;
import pages.HomePage;

public class StepImplementation {
    private final HomePage homePage = new HomePage();

    @Step("hepsiburada ana sayfasına git")
    public void hepsiburdaAnaSayfayaGit() {
        homePage.anasayfayaGit();
    }

    @Step("<searchbox_anasayfa> li elemente tıkla")
    public void elementeTikla(String key) {
        homePage.elementeTikla(key);
    }

    @Step("<searchbox_inputfield_anasayfa> li elemente <Bilgisayar> değerini yaz")
    public void aramaYap(String key, String text) {
        homePage.aramaAlaninaDegerGir(key, text);
    }

    @Step("hepsiburada cookie leri kabul et")
    public void cookieKabulEt() {

    }

    @Step("<urun_listesi_baslik> li elementin text <Bilgisayar> ni doğrula")
    public void elementTextDogrula(String key, String text) {
        homePage.elementTextDogrula(key, text);
    }
}
