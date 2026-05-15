package ec.estivo.edu.elona_prueba1.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {

    // Contador atómico para que sea thread-safe (Tarea 4)
    private final AtomicInteger requestCounter = new AtomicInteger(0);

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) {
        int currentCount = requestCounter.incrementAndGet();
        long t0 = System.currentTimeMillis();

        req.setAttribute("t0", t0);
        req.setAttribute("requestNumber", currentCount); // Guardamos el número para el log final

        // TAREA 4: Agregar header X-Request-Count
        resp.addHeader("X-Request-Count", String.valueOf(currentCount));

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception ex) {
        Long t0 = (Long) req.getAttribute("t0");
        Integer count = (Integer) req.getAttribute("requestNumber");
        long elapsed = (t0 == null) ? -1 : (System.currentTimeMillis() - t0);

        // TAREA 4: Mostrar en consola con el formato pedido: Request #N → método URI tiempo
        System.out.println("Request #" + count + " → " + req.getMethod() + " " + req.getRequestURI() + " " + elapsed + "ms");

        System.out.println("afterCompletion -> status: " + resp.getStatus());
    }
}
