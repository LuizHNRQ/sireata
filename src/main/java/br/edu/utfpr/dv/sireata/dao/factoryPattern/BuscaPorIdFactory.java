package br.edu.utfpr.dv.sireata.dao.factoryPattern;

import br.edu.utfpr.dv.sireata.dao.tiposDeFactory.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BuscaPorIdFactory {

    public static SearchAtaDAO novaBusca(TipoDeBusca tipo, int id, Connection conn, Statement stmt, ResultSet rs){

        BuscarPorId busca = null;
        switch ( tipo ){
            case AnexoDAO:
                busca = new SearchAnexoDAO(id, conn, stmt,rs);
                break;
            case AtaDAO:
                busca = new SearchAtaDAO(id, conn, stmt,rs);
                break;
            case OrgaoDAO:
                busca = new SearchOrgaoDAO(id, conn, stmt,rs);
                break;
            case PautaDAO:
                busca = new SearchPautaDAO(id, conn, stmt,rs);
                break;
            case CampusDAO:
                busca = new SearchCampusDAO(id, conn, stmt,rs);
                break;
            case UsuarioDAO:
                busca = new SearchUsuarioDAO(id, conn, stmt,rs);
                break;
            case ComentarioDAO:
                busca = new SearchComentarioDAO(id, conn, stmt,rs);
                break;
            case DepartmentDAO:
                busca = new SearchDepartmentDAO(id, conn, stmt,rs);
                break;
        }

        return null;
    }
}
