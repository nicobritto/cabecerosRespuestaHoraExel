package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/HoraServlet")
public class HoraServlet extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("refresh","1" );//aca indica que se va resfrescar el navegador cada 1 segundo
        Date fecha=new Date();
        //vamos a darle un formato ala fecha con SimpleDateFormat por si no aparece dia la hs todo
        SimpleDateFormat formateador=new SimpleDateFormat("'hora actualizada 'HH:mm:ss");
        //ahora le vamos a dar formato ala hs con nuestro formateador
        String horaConFormato=formateador.format(fecha);
        PrintWriter out=response.getWriter();
        out.print(horaConFormato);
        out.close();
}
    
    
}
