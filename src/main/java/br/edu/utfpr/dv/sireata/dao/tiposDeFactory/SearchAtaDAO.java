package br.edu.utfpr.dv.sireata.dao.tiposDeFactory;

import br.edu.utfpr.dv.sireata.dao.AtaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchAtaDAO implements BuscarPorId {


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

        conn = ConnectionDAO.getInstance().getConnection();
        stmt = conn.prepareStatement(
                "SELECT atas.*, orgaos.nome AS orgao, p.nome AS presidente, s.nome AS secretario " +
                        "FROM atas INNER JOIN orgaos ON orgaos.idOrgao=atas.idOrgao " +
                        "INNER JOIN departamentos ON departamentos.idDepartamento=orgaos.idDepartamento " +
                        "INNER JOIN usuarios p ON p.idUsuario=atas.idPresidente " +
                        "INNER JOIN usuarios s ON s.idUsuario=atas.idSecretario " +
                        "WHERE idAta = ?");

        stmt.setInt(1, id);

        rs = stmt.executeQuery();

        try{
        if(rs.next()){
            return this.carregarObjeto(rs);
        }else{
            return null;
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