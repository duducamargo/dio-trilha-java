package classes;

import interfaces.AparelhoTelefonico;
import interfaces.EmailTelefone;
import interfaces.NavegadorNaInternet;
import interfaces.ReprodutorMusical;

public class IPhone implements AparelhoTelefonico, ReprodutorMusical, NavegadorNaInternet, EmailTelefone{

    private boolean tocandoMusica = false;

    @Override
    public void exibirPagina(String url) {
        System.out.println("Exibindo a Página de URL: " + url + "...");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Adicionando nova Aba no Navegador");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Atualizando a Página do Navegador");
    }

    @Override
    public void tocar(String musica) {
        System.out.println("Tocando a Música " + musica + "...");
        setTocandoMusica(true);
    }

    @Override
    public void pausar() {
        if(getTocandoMusica() == true) {
            System.out.println("Pausando a Música...");
            setTocandoMusica(false);
        }
        else {
            System.out.println("Nenhuma Música está sendo tocada no momento...");
        }
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("Selecionando a Música " + musica + "...");
    }

    @Override
    public void ligar(String numero) {
        System.out.println("Ligando para o Número " + numero + "...");
    }

    @Override
    public void atender() {
        System.out.println("Atendendo o Telefone...");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando o Correio de Voz...");
    }

    
    @Override
    public void mandarEmail(String destinatario) {
        System.out.println("Mandando Email para " + destinatario + "...");
    }
    
    @Override
    public void lerEmail() {
        System.out.println("Lendo Emails...");
    }
    
    public boolean getTocandoMusica() {
        return tocandoMusica;
    }

    public void setTocandoMusica(boolean tocandoMusica) {
        this.tocandoMusica = tocandoMusica;
    }
    
    
}
