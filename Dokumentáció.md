# AutóBérlés Specifikáció

## **Jelenlegi helyzet**
A mindennapokban rengeteg ember szorul arra, hogy autót béreljen, ugyanis nem mindenki teheti meg, hogy sját autója legyen. Ennek az alkalmazásnak ez a lényege, hogy viszonylag gyorsan olcsón és jó minőségű autóhoz jusson a felhasználó.

## **A rendszer célja**

Az a tervünk, hogy ebben a rövid időben egy stabilan működő béta applikációt csináljunk, ami jól szemlélteti, hogy hogyan tudunk autót bérelni.

### Funkcionális követelmények
Csoport azonosító | Követelmény azonosító | Leírás
----------|---------|-----

U| u_browse | Autók böngészése
U| u_reserve | kiválasztott autó lefoglalása
U| u_purchase | fizetés



## Megfeleltetés	
- Autófoglalás felhasználók számára (u_reserve, u_purchase)



## Forgatókönyvek
A mobil applikáció lokális adatbáziskapcsolattal fog (sharepref) rendelkezni, aminek segítségével tároljuk az autó paramétereit. Az alap koncepció, hogy bejelentkezés után az autók listájában kikereshetjük a kívánt autót, majd utána egyből bérelhetjük is a járművet.
Lesz egy login felület, illetve egy register felület ahol az új felhasználók profilt tudnak készíteni és így igénybe venni a szolgáltatásokat!


## Fogalomszótár
	Android Studio + Java : A szoftvert Android Studio fejlesztőkörnyezetben fogjuk létrehozni Java nyelven, ami a Kotlin mellett a legelterjedtebb és általunk leginkább 		tanult oop nyelv.
	Bug: A bug a számítógépes programhiba elterjedt elnevezése. Előfordulásakor a számítógépes szoftver hibás eredményt ad, vagy a tervezettől eltérően viselkedik. 
	Beta: A béta verziójú programokon általában már csak apró fejlesztéseket, bővítéseket hajtanak végre, és a módosítások legnagyobb része inkább a hibák javítására és kompatibilitási problémák megoldására korlátozódik.
	Alpha: Az alfa verziójú programok általában még erősen fejlesztési fázisban vannak, funkciókészletük nem végleges, és számos szoftverhibával rendelkeznek.


## **Vágyálom rendszer**
Minnél gördülékenyebb és egyszerű andorid alkalmazás fejlesztése, folyamatos nyomkövetés a szabad illetve foglalt autókkal kapcsolatban. A precíz és bizalom gerjesztő megjelenés illetve a felhasználó első benyomásra megbizzon az alkalmazás hitelességében. Adminisztrációs felület kifejlesztése és továbbfejlesztése. Egyszerű, gyors navigációk és kezelhetőség.
