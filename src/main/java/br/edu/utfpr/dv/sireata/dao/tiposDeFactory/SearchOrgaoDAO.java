package br.edu.utfpr.dv.sireata.dao.tiposDeFactory;

import br.edu.utfpr.dv.sireata.dao.OrgaoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchOrgaoDAO implements BuscarPorId {
    @Override
    public void tryConnection() {

        int id;
        Connection conn ;
        PreparedStatement stmt;
        ResultSet rs ;

        public AtaDAO(int id, Connection conn, Statement stmt, ResultSet rs) {
            this.id = id;
            this.conn = conn;
            this.stmt - stmt;
            this.rs = rs;
        }

        try{
            conn = ConnectionDAO.getInstance().getConnection();
            stmt = conn.prepareStatement(
                    "SELECT orgaos.*, p.nome AS presidente, s.nome AS secretario, departamentos.nome AS departamento FROM orgaos " +
                            "INNER JOIN departamentos ON departamentos.iddepartamento=orgaos.iddepartamento " +
                            "INNER JOIN usuarios p ON p.idusuario=orgaos.idpresidente " +
                            "INNER JOIN usuarios s ON s.idusuario=orgaos.idsecretario " +
                            "WHERE orgaos.idOrgao = ?");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if(rs.next()){
                return this.carregarObjeto(rs);
            }else{
                return null;
            }
        }finally{
            if((rs != null) && !rs.isClosed())
                rs.close();
            if((stmt != null) && !stmt.isClosed())
                stmt.close();
            if((conn != null) && !conn.isClosed())
                conn.close();
        }
    }
}
