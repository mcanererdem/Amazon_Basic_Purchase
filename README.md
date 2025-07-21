# BasicPurchase Test Otomasyon Projesi

## Proje Amacı
Bu proje, Hepsiburada benzeri bir e-ticaret sitesinde temel satın alma akışını Gauge ve Selenium WebDriver kullanarak otomatik test etmeyi amaçlar. Testler, kullanıcıların siteye giriş yapmasından ürün arama, sepete ekleme ve satın alma adımlarına kadar olan süreci kapsar.

## Kullanılan Teknolojiler
- **Java 17**
- **Gauge** (BDD test framework)
- **Selenium 4** (Web otomasyon)
- **WebDriverManager** (Driver yönetimi)
- **Maven** (Proje yönetimi)

## Proje Yapısı
- `src/test/java/` altında step implementasyonları, sayfa nesneleri ve yardımcı sınıflar bulunur.
- `specs/` ve `specs/concepts/` altında Gauge senaryoları ve konseptleri yer alır.
- `element-infos/elements.json` dosyasında sayfa elementlerinin tanımları tutulur.

## Test Akışı (spec ve cpt dosyalarına göre)
1. **Hepsiburada ana sayfasına git**
   - Ana sayfa açılır.
2. **Hepsiburada cookie’leri kabul et**
   - Cookie uyarısı varsa kabul edilir.
3. **Arama alanına değer gir ve arama yap**
   - Arama kutusuna “Bilgisayar” yazılır ve arama yapılır.
   - Arama sonuç başlığı doğrulanır.
4. **Arama listesinden ürün seç**
   - Ürün listesinde üçüncü ürün seçilir.
5. **Seçilen ürünü doğrula**
   - Seçilen ürünün başlığı doğrulanır.
6. **Ürünü sepete ekle**
   - Ürün sepete eklenir ve sepete gidilir.
7. **Sepette ürünü doğrula**
   - Sepetteki ürün bilgileri doğrulanır.
8. **Alışverişi tamamla**
   - Satın alma işlemi başlatılır.
9. **Hepsiburada giriş yap**
   - E-posta ve şifre girilir.
   - Giriş butonuna tıklanır. Eğer (authorization hatası) alınırsa, authentication ile tekrar denenir.
10. **Yeni adres ekle**
    - Yeni adres ekleme ekranı açılır.
11. **Adres bilgilerini gir**
    - Ad, soyad, telefon, adres tipi, kısa adres adı ve ilk adres seçimi yapılır.

## Testleri Çalıştırma
1. Gerekli bağımlılıkları yüklemek için:
   ```
   mvn clean install
   ```
2. Testleri çalıştırmak için:
   ```
   gauge run specs
   ```
3. Debug için:
   ```
   set GAUGE_JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:55862
   gauge run specs
   ```
   Ardından IDE'den remote debug ile 55862 portuna bağlanabilirsin.

## Notlar
- Step implementasyonlarında veya hook'larda ExecutionContext ile adım, senaryo ve spec bilgilerine erişilebilir.
- Login adımında özel hata yönetimi ve authentication işlemleri uygulanmıştır.
- Proje, kolayca yeni senaryolar ve adımlar eklenerek genişletilebilir.
