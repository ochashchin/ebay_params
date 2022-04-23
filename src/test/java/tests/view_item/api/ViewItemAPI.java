package tests.view_item.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.HashMap;
import java.util.Map;

public class ViewItemAPI extends BaseTest {

    @Test()
    public void test_GET_add_item_to_cart() {

// https://www.ebay.com/cta/addtocart?item=175037940958&quantity=1&variation_id=474198318254&_trksid=p2047675.l1473&cb=jQuery1701764016869238032_1649135910452&_=1649136029672

        RestAssured.baseURI = "https://www.ebay.com/";

        Response response = RestAssured
                .given().relaxedHTTPSValidation()
                .basePath("cta/")
                .queryParam("item", "175037940958")
                .queryParam("quantity", "1")
                .queryParam("variation_id", "474198318254")
                .queryParam("_trksid", "p2047675.l1473")
                .queryParam("cb", "jQuery1701764016869238032_1649135910452")
                .queryParam("_", "1649136029672")
                .when()
                .get("addtocart")
                .then()
                .statusCode(200)
                .log().body()
                .extract().response();

        Assert.assertTrue(response.statusCode() == 200);
    }

    @Test()
    public void test_GET_item_page() {
        RestAssured.baseURI = "https://www.ebay.com/";
        Map<String,Object> baseHeaders = new HashMap<String,Object>();
        baseHeaders.put("Accept", "*/*");
        baseHeaders.put("Accept-Encoding", "gzip, deflate, br");
        baseHeaders.put("Accept-Language", "en-US,en;q=0.9");
        baseHeaders.put("Connection", "keep-alive");
        baseHeaders.put("Content-Type", "application/json; charset=utf-8");
        baseHeaders.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.82 Safari/537.36");

        Response response = RestAssured
                .given().relaxedHTTPSValidation()
                .headers(baseHeaders)
                .basePath("itm/175037940958")
                .header("Cookie", "cid=7SuPGV6bs15yaDIU%231681603555; __deba=kO0abC1m10k6ffmrgaXg5Z4pjsqYysO46VWn6dhH3pGv63nYTFtw0_eVruDwgIoevbUbkomjMgecalyTI6_r2iXg2zWBBx7IRAU3RXsiSxZ-E4XSy8CgF0AMwZ_2oxwL; __uzma=bf36f4e0-0923-4e01-864a-b2bfb74e0e5e; __uzmb=1649195399; __uzmc=173721035142; __uzmd=1649195399; __uzme=6886; __uzmf=7f600029b4046d-f312-4c6b-a061-7cb3d1c5ea1c16491953990620-c17f439b5d8313a310; ebay=%5Ejs%3D1%5Esbf%3D%23%5E; JSESSIONID=56B7BB688FAEF903CA7B52B734C155A6; s=CgAD4ACBiTg/CZDcwYTUzYWIxN2YwYTM3NDMyMjcyM2EyZmZiMDc5YzMCKQrm; ak_bmsc=F91C528EE9EEDE8AD533144E6D33DC72~000000000000000000000000000000~YAAQN3tBF6F6leZ/AQAAK0RA/A8InfcAusCFzefhg9PAK25fn2Eb8atCSaTSBYkmI4uh/d04dzi/lGMCJv5YLQ3C8ydftCF2w2XMmQfAA4S1zG8los/wz1Th/jsKB+22mdE0lXV2yFd7JOhfpTuRly48no7boUr43J1VieJETY1Y4K3DUngl7+7jozeVlZ6VuHOXM3871ARqq5y0wG+3QX/69ejFuT8XvhGi7rubKmzwB5U0vrDMB44Ha4Ti/VNPnNqNcv0tnlnQc9Bf7rMKtTx0K0wzgNvbJYpfTGaTmi9kCDLQYFPSZRSTusoqiYV0FGpIkV8dXrJ0pGZoCJousaGo1lBpMv0erGDBxbEmsoDO7D/bjftr2U2R; dp1=bu1p/QEBfX0BAX19AQA**660f453b^pbf/%2320000000000000000000000000004642e11bb^bl/US660f453b^; nonsession=CgAAIABxidGs7MTY0OTE5NjYxMHgxNzUwMzc5NDA5NTh4MHgyTgDKACBmD0U7ZDcwYTUzYWIxN2YwYTM3NDMyMjcyM2EyZmZiMDc5YzMAywABYkzlQzLWKbUG; bm_sv=4960B25E17B8D0CDE4D85460B3CE9EF9~jv0cTELmJGnctPTOoy8D4oVW9hcQ9LpQF88zL9fmv8a71tEcMjegJuu2/Dozu6MnG18OjhueevaDtGmROAvZHua2HgKb4vfEUmeqZwwOvdIe3pPylhx3rXMMOmmkYv8oFfuJbdKfAjltp8rfZcuqxQ==")
                .header("Cache-Control", "no-cache")
                .header("Host", "www.ebay.com")
                .when()
                .get()
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response();

        Assert.assertTrue(response.statusCode() == 200);
    }

}