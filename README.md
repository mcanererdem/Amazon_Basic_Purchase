# BasicPuchase Test Otomasyon Projesi

Bu projede Gauge, Selenium ve Gson kullanılarak otomasyon testleri yazılır. Elementler `src/test/resources/element-infos/elements.json` dosyasında anahtar (key), selector (value) ve tür (type: id, css, xpath) olarak tanımlanır.

## Element Yönetimi
- Tüm elementler `ElementStore` sınıfı ile belleğe alınır.
- Step veya helper fonksiyonlarda sadece element key'i ile işlem yapılır.
- `ElementStore.getBy("form_button")` ile ilgili elementin Selenium By nesnesi alınır.

## Örnek Step Kullanımı
```java
@Step("Click element with key <elementKey>")
public void clickElementWithKey(String elementKey) {
    By by = ElementStore.getBy(elementKey);
    WebElement element = Driver.webDriver.findElement(by);
    element.click();
}
```

## Kendi Helper Fonksiyonlarını Yazabilirsin
ElementStore sadece By nesnesi döndürür. Kendi element helper sınıfını yazıp, Selenium fonksiyonlarını özelleştirebilirsin.

## Gereksinimler
- Java
- Maven
- Gauge

Kısa ve sürdürülebilir bir test otomasyon altyapısı için tasarlanmıştır.