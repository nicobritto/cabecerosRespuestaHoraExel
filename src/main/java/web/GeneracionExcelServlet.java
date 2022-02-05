package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //indicamos el tipo de documento que vamos a enviar al navegador exel
        response.setContentType("application/vnd.ms-excel");
        //tambien lo que vamos a indicar que al hacer click descargue el documento
        response.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
        //para un uso mas profesional de exel utilizar la libreria de poi.apache.org
        //ahora vamos a indicarle al novegador que no almacena cache y que cada vez q se descargue tenga informacion actualizada
        response.setHeader("Pragma", "no-cache");//son varias variables para decirle que no guarde cache
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", -1);

        //desplegamos la informacion al cliente acordarse siemppre sel PrintWriter
        PrintWriter out = response.getWriter();
        out.println("\tValores");
        out.println("\t1");
        out.println("\t2");
        out.println("Total\t=SUMA(b2:b3)");
        out.close();

    }

}
