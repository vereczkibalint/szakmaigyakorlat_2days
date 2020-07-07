# AutóBérlés Specifikáció

## **Jelenlegi helyzet**
A mindennapokban rengeteg ember szorul arra, hogy autót béreljen, ugyanis nem mindenki teheti meg, hogy sját autója legyen. Ennek az alkalmazásnak ez a lényege, hogy viszonylag gyorsan olcsón és jó minőségű autühoz jusson a felhasználó.

## **A rendszer célja**

Az a tervünk, hogy ebben a rövid időben egy stabilan működő béta applikációt csináljunk, ami jól szemlélteti, hogy hogyan tudunk autót bérelni.

### Funkcionális követelmények
Csoport azonosító | Követelmény azonosító | Leírás
----------|---------|-----
A| A_login | admin bejelentkezési felület
A| A_moderate | admin lehetőségek autó bérlések módosítására, törlésére
U| u_browse | Autók böngészése
U| u_reserve | kiválasztott autó lefoglalása
U| u_purchase | fizetés
U| u_cancel | autófoglalás visszamondása


## Megfeleltetés	
- Autófoglalás felhasználók számára (u_reserve, u_purchase)
- Az időpontokat és a feltételeket az adminok módosíthatják (A_moderate)
- Kereső funkció, ahol lehetőség van az autó típus, teljesítmény,
  és márka szerinti keresésére(u_browse, u_search)
- Lehetőség legyen az autók visszamondására, törlésére bizonyos feltételekkel(u_cancel, u_delete)
- Felhasználók adatainak biztonságos kezelése(passw_enc, user_data_scope)


## Forgatókönyvek
A weboldal adatbáziskapcsolattal fog rendelkezni, ahol tároljuk az autó foglalásra felkínált lehetőségeket. Az alap koncepció, hogy bejelentkezés után az autók listájában kikereshetjük a kívánt autót, majd utána egyből bérelhetjük is a járművet.
Lesz egy login felület, illetve egy register felület ahol az új felhasználók profilt tudnak készíteni és így igénybe venni a szolgáltatásokat!


## Fogalomszótár
	JavaScript: A JavaScript programozási nyelv egy objektumorientált, prototípus alapú szkriptnyelv, amelyet weboldalakon elterjedten használnak.
	Bug: A bug a számítógépes programhiba elterjedt elnevezése. Előfordulásakor a számítógépes szoftver hibás eredményt ad, vagy a tervezettől eltérően viselkedik. 
	Beta: A béta verziójú programokon általában már csak apró fejlesztéseket, bővítéseket hajtanak végre, és a módosítások legnagyobb része inkább a hibák javítására és kompatibilitási problémák megoldására korlátozódik.
	Alpha: Az alfa verziójú programok általában még erősen fejlesztési fázisban vannak, funkciókészletük nem végleges, és számos szoftverhibával rendelkeznek.


## **Vágyálom rendszer**
Minnél gördülékenyebb és egyszerű andorid alkalmazás fejlesztése, folyamatos nyomkövetés a szabad illetve foglalt autókkal kapcsolatban. A precíz és bizalom gerjesztő megjelenés illetve a felhasználó első benyomásra megbizzon az oldal
hitelességében. Adminisztrációs felület kifejlesztése és továbbfejlesztése. Egyszerű, gyors navigációk és kezelhetőség.
