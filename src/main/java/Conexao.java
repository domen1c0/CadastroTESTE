import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;

public class Conexao {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList();

        boolean rodando = true;

        while(rodando){
            System.out.println("[1] Cadastrar usuário");
            System.out.println("[2] Listar todos usuários cadastrados");
            System.out.println("[3] Procurar usuário por email");
            System.out.println("[4] Atualizar dados de um usuário");
            System.out.println("[5] Remover usuário");
            System.out.println("[6] Sair");
            System.out.print("Digite a opção: ");
            String opcao = scan.nextLine();

            switch (opcao){
                case "1": {
                    System.out.println("=======CADASTRO DE USUARIO=======");
                    System.out.print("Digite o email: ");
                    String email = scan.nextLine();
                    System.out.print("Digite a senha: " );
                    String senha  = scan.nextLine();
                    Usuario user = new Usuario(email, senha);
                    usuarios.add(user);
                    System.out.println("Cadastrado com sucesso!!!");
                    System.out.println("================================");
                    break;
                }
                case "2": {
                    System.out.println("=====USUÁRIOS CADASTRADOS====");
                    for (int i=0; i<usuarios.size(); i++){
                        Usuario temp = usuarios.get(i);
                        System.out.println("Usuário " + i);
                        System.out.println("\tEmail: " + usuarios.get(i).getEmail());
                        System.out.println("\tSenha: " + usuarios.get(i).getSenha());
                        System.out.println("================================");

                    }
                    break;
                }
                case "3": {
                    System.out.println("=======PROCURAR POR EMAIL=======");
                    System.out.print("Digite o email: ");
                    String e = scan.nextLine();
                    boolean encontrado = false;
                    for (int i=0; i<usuarios.size(); i++){
                        Usuario temp = usuarios.get(i);
                        if(e.equals(temp.getEmail())){
                            System.out.println("Usuário encontrado");
                            System.out.println("\tEmail: " + temp.getEmail());
                            System.out.println("\tSenha: " + temp.getSenha());
                            System.out.println("================================");
                            encontrado = true;
                            break;
                        }
                    }
                    if(!encontrado){
                        System.out.println("Usuário com este email não encontrado!!");
                        System.out.println("================================");
                    }
                    break;
                }
                case "4": {
                    System.out.println("======ATUALIZAÇÃO DE USUÁRIO=====");
                    for(int i=0; i<usuarios.size(); i++){
                        Usuario temp = usuarios.get(i);
                        System.out.println("[" + i + "] " + temp.getEmail());
                    }
                    System.out.print("Digite o valor de referência: ");
                    int ref = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Digite o novo email: ");
                    String newEmail = scan.nextLine();
                    System.out.println("Digite a nova senha: ");
                    String newSenha = scan.nextLine();

                    Usuario u = usuarios.get(ref);
                    u.setEmail(newEmail);
                    u.setSenha(newSenha);
                    System.out.println("Atualizado com sucesso!!!");
                    System.out.println("================================");
                    break;
                }
                case "5": {
                    System.out.println("=====REMOVER USUÁRIO=====");
                    for(int i=0; i<usuarios.size(); i++){
                        Usuario temp = usuarios.get(i);
                        System.out.println("[" + i + "] " + temp.getEmail());
                    }
                    System.out.print("Digite o valor de referência: ");
                    int ref = scan.nextInt();
                    scan.nextLine();

                    usuarios.remove(ref);
                    System.out.println("Usuário removido com sucesso!!!");
                    System.out.println("================================");
                    break;
                }
                case "6": {
                    rodando = false;
                    break;
                }
            }
        }
        scan.close();
    }
}
