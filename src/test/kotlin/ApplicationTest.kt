import com.example.getUSDtoEUR
import com.example.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ApplicationTest {

    @Test
    fun testUSD() = testApplication {
        application {
            configureRouting()
        }
        val response = client.get("/convert/USDtoEUR?value=1")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals(getUSDtoEUR(), response.bodyAsText().toDouble(), 0.01)
    }

    @Test
    fun testEUR() = testApplication {
        application {
            configureRouting()
        }
        val response = client.get("/convert/EURtoUSD?value=1")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals(1 / getUSDtoEUR(), response.bodyAsText().toDouble(), 0.01)
    }

    @Test
    fun testError() = testApplication {
        application {
            configureRouting()
        }
        var response = client.get("/convert/USDtoEUR?=1")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("ERROR: No input value", response.bodyAsText())

        response = client.get("/convert/EURtoUSD?value=Nine")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("ERROR: input value is not a number", response.bodyAsText())
    }
}