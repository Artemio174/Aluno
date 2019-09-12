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

import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

    public static void alterar(ManutencaoAluno man){
        Aluno objeto = new Aluno();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfcodigo.getText()));
        objeto.setNome(man.jtfnome.getText());
        objeto.setSobrenome(man.jtfsobrenome.getText());
        objeto.setSexo(man.jtfsexo.getText());
        
        boolean resultado = AlunoDao.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    public static void excluir(ManutencaoAluno man){
        Aluno objeto = new Aluno();
        objeto.setCodigo(Integer.parseInt(man.jtfcodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = AlunoDao.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Sobrenome");
        modelo.addColumn("Sexo");
        List<Aluno> resultados = AlunoDao.consultar();
        for (Aluno objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNome());
            linha.add(objeto.getSobrenome());
            linha.add(objeto.getSexo());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
    }
    

