import Supermarket.*;
import java.util.Scanner;

public class Main {

	private static final String CRIA = "CRIA";
	private static final String CARRINHO = "CARRINHO";
	private static final String ARTIGO = "ARTIGO";
	private static final String DEPOSITA = "DEPOSITA";
	private static final String REMOVE = "REMOVE";
	private static final String LISTA = "LISTA";
	private static final String PAGA = "PAGA";
	private static final String SAIR = "SAIR";
	
	private static final String CRIA_CARRINHO_SUCCESS = "Carrinho criado com sucesso.\n";
	private static final String CRIA_PRODUTO_SUCCESS = "Artigo criado com sucesso.\n";
	private static final String DEPOSIT_SUCCESS = "Artigo adicionado com sucesso.\n";
	private static final String REMOVE_SUCCESS = "Artigo removido com sucesso.\n";
	private static final String SAIR_SUCCESS = "Volte sempre.\n";
	
	public static void main(String[] args) {
		
		Main.commands();
		

	}
	
	private static void commands() {
		
		SupermarketSystem supermarket = new SupermarketSystemClass();
		Scanner input = new Scanner(System.in);
		String command;		 
		
		do {
		command = input.next().toUpperCase();
		switch(command) {
		case CRIA -> createCommand(input, supermarket);
		case DEPOSITA ->  deposit(input, supermarket);
		case REMOVE -> remove(input, supermarket);
		case LISTA -> list(input, supermarket);
		case PAGA -> pay(input, supermarket);
		case SAIR -> System.out.println(SAIR_SUCCESS);
	
		}
			
		}while(!command.equals(SAIR));
		input.close();
		}
	
	private static void createCommand(Scanner input, SupermarketSystem supermarket) {
		String secondCommand;
		secondCommand = input.next().toUpperCase();
		switch(secondCommand) {
		case CARRINHO-> createCart(input, supermarket);
		case ARTIGO-> createProduct(input, supermarket);
		}
	}

	private static void createCart(Scanner input, SupermarketSystem supermarket) {
		
		String cartId ;
		int cartCapacity;
		
		
		try {
			
			cartId = input.next();
			cartCapacity = input.nextInt();
			input.nextLine().trim();
			supermarket.createCart(cartId, cartCapacity);
			System.out.println(CRIA_CARRINHO_SUCCESS);			
			
		}catch(ExistentCartException e) {
			System.out.println(e.getMessage());
		}
	}
	private static void createProduct(Scanner input, SupermarketSystem supermarket) {
		String productName ;
		int productPrice, productVolume;
		
		try {
			productName = input.next();
			productPrice = input.nextInt();
			productVolume = input.nextInt();
			input.nextLine().trim();
			supermarket.createProduct(productName,productPrice,productVolume);
			System.out.println(CRIA_PRODUTO_SUCCESS);
			
		}catch(ExistentProductException e) {
			System.out.println(e.getMessage());
		}
	}
	private static void deposit(Scanner input, SupermarketSystem supermarket) {
		String productName, cartId;
		
		try {
			productName = input.next();
			cartId = input.next();
			input.nextLine().trim();
			supermarket.deposit(productName, cartId);
			System.out.println(DEPOSIT_SUCCESS);
			
		}catch(InexistentCartException e) {
			System.out.println(e.getMessage());
		}catch(InexistentProductException e) {
			System.out.println(e.getMessage());
		}catch(MaxCapacityException e) {
			System.out.println(e.getMessage());
		}
	}
	private static void remove(Scanner input, SupermarketSystem supermarket) {
		
		String productName, cartId;
		
		try {
			productName = input.next();
			cartId = input.next();
			input.nextLine().trim();
			supermarket.remove(productName, cartId);
			System.out.println(REMOVE_SUCCESS);
			
		}catch(InexistentCartException e){
			System.out.println(e.getMessage());
		}catch(InexistentProductInCartException e) {
			System.out.println(e.getMessage());
		}
	}
	private static void list(Scanner input, SupermarketSystem supermarket) {
		String cartId;
		
		try {
			cartId = input.next();
			input.nextLine().trim();
			java.util.Iterator<Product> it = supermarket.listProducts(cartId);
			while(it.hasNext()) {
				Product product = it.next();
				System.out.println(product.getName()+ " " + product.getPrice());
			}
			System.out.println();
			
		}catch(EmptyCartException e) {
			System.out.println(e.getMessage());
		}catch(InexistentCartException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void pay(Scanner input, SupermarketSystem supermarket) {
		
		String cartId;
		
		try {
			cartId = input.next();
			input.nextLine().trim();
			System.out.println(supermarket.getTotalCartPrice(cartId));
			System.out.println();
			supermarket.cleanCart(cartId);
		}catch(InexistentCartException e) {
			System.out.println(e.getMessage());
		}catch(EmptyCartException e){
			System.out.println(e.getMessage());
		}
	}

	
	
	

	
	
	
	
	
	
	
	
	
	
}


