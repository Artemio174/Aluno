/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.AlunoDao;
import javax.swing.JOptionPane;
import modelo.Aluno;
import tela.manutencao.ManutencaoAluno;


/**
 *
 * @author netom
 */
public class ControladorAluno {
    public static void inserir(ManutencaoAluno man){
        Aluno objeto = new Aluno();
        objeto.setNome(man.jtfnome.getText());
        objeto.setSobrenome(man.jtfsobrenome.getText());
         objeto.setSexo(man.jtfsexo.getText());
        
        boolean resultado = AlunoDao.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}


    //To change body of generated methods, choose Tools | Templates.

    public static void alterar(ManutencaoAluno aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    

