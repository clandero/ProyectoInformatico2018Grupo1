/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Anuncio;
import Modelo.Usuario;
import Modelo.AreadeInteres;

import static java.lang.System.out;

import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author berko
 */
public class AnuncioDao {

    private static Connection conn = null;

    public AnuncioDao() {
        if (conn == null) {
            conn = DatabaseConnect.getConn();
        }
        System.out.println("instanced anunciodao");
    }

    public void addTema(int n_anun, AreadeInteres area) {
        try {
            String query = "INSERT INTO anuncio_area(n_anun, tema)"
                    + "VALUES ((?),(?))";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, n_anun);
            ps.setString(2, area.getTema());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void save(Anuncio a, Usuario u, AreadeInteres area) {
        try {
            // crear anuncio en bd
            String query = "INSERT INTO anuncio "
                    + "(titulo, contenido, correo, fecha_anuncio)"
                    + "VALUES ((?),(?),(?),(?))";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, a.getTitulo());
            ps.setString(2, a.getContent());
            ps.setString(3, u.getCorreo());
            ps.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
            ps.execute();

            query = "SELECT * "
                    + "FROM anuncio "
                    + "WHERE titulo=(?) and  contenido=(?) and correo=(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, a.getTitulo());
            st.setString(2, a.getContent());
            st.setString(3, u.getCorreo());
            st.execute();
            ResultSet rs = st.getResultSet();
            System.out.println("AQUIIIIIIIIIIIIIIIII EN ANUNCIODAOdeRS" + rs);
            if (rs.next()) {
                int n_anun = rs.getInt("n_anun");
                java.sql.Date fecha = rs.getDate("fecha_anuncio");
                a.setN_anun(n_anun);
                a.setFecha_anuncio(fecha);
                a.setCorreo(u.getCorreo());
                System.out.println("AQUIIIIIIIIIIIIIIIII EN ANUNCIODAO" + area.getTema());

                query = "INSERT INTO anuncio_area(n_anun, tema)"
                        + "VALUES ((?),(?))";
                ps = conn.prepareStatement(query);
                ps.setInt(1, n_anun);
                ps.setString(2, area.getTema());
                ps.execute();

            } else {
                System.out.println("AQUIIIIIIIIIIIIIIIII EN ANUNCIODAO de NEXT" + rs.next());
            }
            //
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    /**
     * Actualiza un anuncio en la base de datos con un nuevo titulo, 
     * contenido y tema.
     * 
     * @param n_anun Numero del anuncio a actualizar
     * @param titulo Nuevo titulo del anuncio
     * @param contenido Nuevo contenido del anuncio
     * @param tema Nuevo tema/area de interes del anuncio
     */
    public void update(int n_anun, String titulo, String contenido, String tema) {
        try {
            //Debe actualizar tabla anuncio + tabla anuncio_area
            String query = "UPDATE anuncio "
                    + "SET titulo = '" + titulo
                    + "', contenido = '" + contenido
                    + "' WHERE n_anun = " + n_anun;
            Statement stmt = conn.createStatement();
            System.out.println("Previo primer update");
            stmt.executeQuery(query);

            query = "UPDATE anuncio_area "
                    + "SET tema = '" + tema
                    + "', WHERE n_anun = " + n_anun;
            System.out.println("Previo segundo update");
            
            stmt.executeQuery(query);
            System.out.println("worked?");
            //TODO: check returned result
        } catch (SQLException ex) {
            Logger.getLogger(AnuncioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int n_anun) {
        try {
            String query = "SELECT tema"
                    + "FROM anuncio_area as a"
                    + "WHERE a.n_anun = (?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, n_anun);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (!(rs.next())) {
                System.out.println("no result");
                return;
            }
            String tema = rs.getString("tema");
            query = "DELETE FROM anuncio_area"
                    + "WHERE tema=(?) AND n_anun=(?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, tema);
            ps.setInt(2, n_anun);
            ps.execute();
            query = "DELETE FROM anuncio"
                    + "WHERE n_anun=(?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, n_anun);
            ps.execute();
            // BORRAR ARCHIVO DEL SERVIDOR

        } catch (SQLException ex) {

        }

    }

    /**
     *
     * @param u Usuario del cual retirar los anuncios que ha creado
     * @return Set con los anuncios
     */
    public Set<Anuncio> getAll(Usuario u) {
        Set<Anuncio> anuncios_usuario = new TreeSet<>();

        String query_anuncio = "SELECT * "
                + "FROM anuncio, anuncio_area "
                + "WHERE anuncio.n_anun = anuncio_area.n_anun "
                + "AND anuncio.correo = '" + u.getCorreo() + "'";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query_anuncio);
            while (rs.next()) {
                int num_anuncio = rs.getInt("n_anun");
                String titulo = rs.getString("titulo");
                String contenido = rs.getString("contenido");
                String fecha_anuncio = rs.getString("fecha_anuncio");
                String tema = rs.getString("tema");
                System.out.println("Fecha retirada: " + fecha_anuncio);
                System.out.println("Tema retirado: " + tema);
                anuncios_usuario.add(new Anuncio(num_anuncio, titulo,
                        u.getCorreo(), contenido, fecha_anuncio, tema));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnuncioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return anuncios_usuario;
    }

    public TreeSet<Anuncio> getAnuncios(TreeSet<AreadeInteres> x) {
        TreeSet<Anuncio> res = new TreeSet<Anuncio>();
        /*ArrayList<AreadeInteres> y = new ArrayList<AreadeInteres>();
        y.add(new AreadeInteres("Estructuras"));*/

        try {
            out.println("AAAAA");
            for (AreadeInteres i : /*y*/ x) {
                String query = "SELECT a.titulo, a.n_anun, a.contenido, us.nombre_usuario, a.fecha_anuncio FROM plataforma_colaborativa.anuncio as a, plataforma_colaborativa.anuncio_area as x, plataforma_colaborativa.usuario as us WHERE a.n_anun = x.n_anun AND x.tema = '" + i.getTema() + "' AND a.correo = us.correo";
                out.println(query);
                PreparedStatement ps = conn.prepareStatement(query);
                ps.execute();
                ResultSet rs = ps.getResultSet();
                while (rs.next()) {
                    out.println(rs.getInt("n_anun"));
                    res.add(new Anuncio(rs.getInt("n_anun"), rs.getString("titulo"), rs.getString("nombre_usuario"), rs.getString("contenido"), rs.getString("fecha_anuncio"), i.getTema()));
                }
            }
            return res;
        } catch (SQLException ex) {
        }
        return null;

    }
}
