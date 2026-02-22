package game.explore;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

enum Platform{PC, PLAYSTATION, XBOX, NINTENDO, MOBILE} 
enum Genre {HORROR,ACTION, ADVENTURE ,RPG , STRATEGEY , SHOOTER ,SURVIVAL, PUZZLE , SPORT , MMO , RHYTHM } 
enum GameType{CARD, PUZZLE ,BOARD, DICE}
enum Material{WOOD,PLASTIC,CARDBOARD,METAL,ACRYLIC,PAPER}

class Game {
    private String gameName;
    private Genre genre;
    private int ageRate;
    private double price;
    private char difficultyLvl;
    private String releaseDate;
   
    protected static ArrayList<Game> gamesList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    
    public static void initializeGames(){
        SinglePlayerGames singleGame1 = new SinglePlayerGames();
        
        singleGame1.setGameName("stardew valley");
        singleGame1.setGenre(Genre.RPG);
        singleGame1.setAgeRate(10);
        singleGame1.setPrice(10.49);
        singleGame1.setDifficultyLvl('M');
        singleGame1.setReleaseDate("2016-02-26");
        singleGame1.setPlatform(Platform.NINTENDO);
        singleGame1.setTotalPlayTime(100);
        singleGame1.setDeveloper("Eric Barone");
        singleGame1.setStoryLength(53);
        singleGame1.setIsCompleted(true);
        singleGame1.setAutoSaveEnabled(false);
        
        Game.gamesList.add(singleGame1);
        
        SinglePlayerGames singleGame2 = new SinglePlayerGames();
        
        singleGame2.setGameName("OMORI");
        singleGame2.setGenre(Genre.HORROR);
        singleGame2.setAgeRate(17);
        singleGame2.setPrice(34.95);
        singleGame2.setDifficultyLvl('M');
        singleGame2.setReleaseDate("2020-12-25");
        singleGame2.setPlatform(Platform.PC);
        singleGame2.setTotalPlayTime(50);
        singleGame2.setDeveloper("OMOCAT");
        singleGame2.setStoryLength(25);
        singleGame2.setIsCompleted(true);
        singleGame2.setAutoSaveEnabled(false);
        
        Game.gamesList.add(singleGame2);
         
        SinglePlayerGames singleGame3 = new SinglePlayerGames();
        
        singleGame3.setGameName("Hollow Knight");
        singleGame3.setGenre(Genre.ACTION);
        singleGame3.setAgeRate(10);
        singleGame3.setPrice(15.00);
        singleGame3.setDifficultyLvl('H');
        singleGame3.setReleaseDate("2017-04-24");
        singleGame3.setPlatform(Platform.PC);
        singleGame3.setTotalPlayTime(50);
        singleGame3.setDeveloper("Team Cherry");
        singleGame3.setStoryLength(25);
        singleGame3.setIsCompleted(true);
        singleGame3.setAutoSaveEnabled(true);
        
        Game.gamesList.add(singleGame3);
        
        MultiplayerGames multiGame = new MultiplayerGames();
        
        multiGame.setGameName("Minecraft");
        multiGame.setGenre(Genre.SURVIVAL);
        multiGame.setAgeRate(10);
        multiGame.setPrice(29.99);
        multiGame.setDifficultyLvl('E');
        multiGame.setReleaseDate("2011-11-18");
        multiGame.setPlatform(Platform.PC);
        multiGame.setTotalPlayTime(90);
        multiGame.setDeveloper("Mojang Studios");
        multiGame.setMaxPlayers(10);
        multiGame.setChatEnabled(true);
        multiGame.setRequiresMembership(false);
        Game.gamesList.add(multiGame);
        
        TabletopGames tableGame = new TabletopGames();
        tableGame.setGameName("Monopoly");
        tableGame.setGenre(Genre.STRATEGEY);
        tableGame.setAgeRate(8);
        tableGame.setPrice(20.00);
        tableGame.setDifficultyLvl('M');
        tableGame.setReleaseDate("1935-01-01");
        tableGame.setNumOfPlayers(4);
        tableGame.setGameType(GameType.BOARD);
        tableGame.setSessionPlayTime(60);
        tableGame.setMaterials(Material.CARDBOARD);
        Game.gamesList.add(tableGame);
    }

    // Method to set gameName
    public void setGameName() {
        while (true) {
            System.out.print("Enter game name: ");
            String input = scanner.nextLine();
            boolean GameExist = false;
            for (Game game : gamesList ) {
                if (game.getGameName().equalsIgnoreCase(input)) { 
                    GameExist = true;
                    break;
                }   
            }
            if(!GameExist){
                if (input.matches("^[A-Za-z0-9_ ]{1,100}$")) {
                    gameName = input;
                    System.out.println("Game name set to: " + gameName);
                    break;
                } else {
                    System.out.println("Invalid game name. Try again.");
                }    
            }else{
                System.out.println("Game name already exist! ");
            }
        }
    }
    // Method to set genre
    public void setGenre() {
        while (true) {
            System.out.print("Enter genre{HORROR,ACTION, ADVENTURE ,RPG , STRATEGEY , SHOOTER ,SURVIVAL, PUZZLE , SPORT , MMO , RHYTHM }: ");
            String input = scanner.nextLine().toUpperCase().trim(); 
            boolean isValidGenre = false;
            for (Genre genre : Genre.values()) {
                if (genre.name().equalsIgnoreCase(input)) { 
                    isValidGenre = true;
                    break;
                }   
            }
            if (isValidGenre) {
                genre = Genre.valueOf(input);
                System.out.println("Genre set to: " + genre);
                break;
            } else {
                System.out.println(input + " is not a valid genre.Try again!");
            } 
        }
    }
    // Method to set ageRate
    public void setAgeRate() {
        while (true) {
            System.out.print("Enter age rate (0-18): ");
            int input = Integer.parseInt(scanner.nextLine());
            if (input >= 0 && input <= 18) {
                ageRate = input;
                System.out.println("Age rate set to: " + ageRate +" years old.");
                break;
            }
            else
                System.out.println("invaild age. Try again!");
                
        }
    }
    // Method to set price
    public void setPrice() {
        while (true) {
            System.out.print("Enter price(in dollars): ");
            double input = Double.parseDouble(scanner.nextLine());
            if (input >= 0 && input<=200) { 
                price = input;
                System.out.println("Price set to: " + price+" $.");
                break;
            }
            System.out.print("invaild price. It must be from 0$ to 200$.\n");
        }
    }
    // Method to set difficulty level
    public void setDifficultyLvl() {
        while (true) {
            System.out.print("Enter difficulty level (E for Easy, M for Medium, H for Hard): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if(input.length() != 1){
                System.out.println("Invalid difficulty level. Must be 1  character try again.");
                continue;
            }
            difficultyLvl = input.charAt(0);
            if (difficultyLvl == 'E' || difficultyLvl == 'M' || difficultyLvl == 'H') {
                
                switch(difficultyLvl){
                    case 'E':{
                        System.out.println("Difficulty level set to: Easy ");
                        return;
                    }
                    case 'M':{
                        System.out.println("Difficulty level set to: Medium ");
                        return;
                    }
                    case 'H':{
                        System.out.println("Difficulty level set to: Hard ");
                        return;
                    }
                }
            } else {
                System.out.println("Invalid difficulty level. Try again.");
                continue; 
            }
        }
    }
    // Method to set release date
    public void setReleaseDate() {
        LocalDate today = LocalDate.now();
        String todayString = today.toString();
        String[] todayArray = todayString.split("-");
        int todayYear =  Integer.parseInt(todayArray[0]);
        int todayMonth =  Integer.parseInt(todayArray[1]);
        int todayDay =  Integer.parseInt(todayArray[2]);
        while (true) {
            System.out.print("Enter release date (YYYY-MM-DD): ");
            String input = scanner.nextLine();
            if (!input.matches("\\d{4}-\\d{2}-\\d{2}")) { // Check if the input matches the date format YYYY-MM-DD
                System.out.println("Invalid format. Please use YYYY-MM-DD.");
                continue;
            }
            String[] parts=input.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            
            
            if(year>todayYear){
                System.out.println("Year cannot be in the future. Try again.");
                continue;
            }
            if(year<1967){
                System.out.println("Year cannot be before 1967. Try again.");
                continue;
            }
            if (month < 1 || month > 12) {
                System.out.println("Invalid month. Must be between 01 and 12.");
                continue;
            }
            if (day < 1 || day > getDaysInMonth(year, month)) {
                System.out.println("Invalid day for the given month.");
                continue;
            }
            
            if ((year>todayYear)||(year==todayYear && month>todayMonth)||(year==todayYear && month==todayMonth && day>todayDay)){
                System.out.println("Date cannot be in the future. Try again.");
                continue;
            }
            
            this.releaseDate = input;
            System.out.println("Release date set to: " + this.releaseDate);
            break;   
        }
    }
    
    private int getDaysInMonth(int year, int month) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;  
            case 2:
                return 28;
            default:
                return 31; 
        }
    }
    // Methods to get gameName, genre, ageRate, price, difficultyLvl and releaseDate
    public String getGameName(){return this.gameName;}
    public Genre getGenre(){return this.genre;}
    public int getAgeRate(){return this.ageRate;}
    public double getPrice(){return this.price;}
    public char getDifficultyLvl(){return this.difficultyLvl;}
    public String getReleaseDate(){return this.releaseDate;}
    
    public void setGameName(String gameName){this.gameName=gameName;}
    public void setGenre(Genre genre){this.genre = genre;}
    public void setAgeRate(int ageRate){this.ageRate= ageRate;}
    public void setPrice(double price){this.price= price;}
    public void setDifficultyLvl(char difficultyLvl){this.difficultyLvl= difficultyLvl;}
    public void setReleaseDate(String releaseDate){this.releaseDate= releaseDate;}
  
    
    @Override
    public String toString() {
        String SdifficultyLvl;
        switch(difficultyLvl){
                    case 'E':{
                        SdifficultyLvl="Easy";
                        break;
                    }
                    case 'M':{
                        SdifficultyLvl="Medium";
                        break;
                    }
                    case 'H':{
                        SdifficultyLvl="Hard";
                        break;
                    }
                    default:{
                        SdifficultyLvl="Easy";
                    }
                }
        return"Game Name: " + this.gameName +
           "\n,Genre: " + this.genre +
           "\n,Age rate: " + this.ageRate +"+"+
           "\n,Price: " + this.price +"$"+
           "\n,difficulty level: " + SdifficultyLvl +
           "\n,Release Date: " + this.releaseDate;
    }

    
   
    public static void displayAllGames() {
        if (gamesList.isEmpty()) {
            System.out.println("No games in the list.");
        } else {
            System.out.println("Games List:");
            int index = 1;
            for (Game game : gamesList) {
                System.out.println("--------------------------------------------");
                System.out.println(index++ + ". " + game); 
            }
        }
    }
    
    public static void searchGames() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the game name to search: ");
        String searchTerm = scanner.nextLine();
        boolean found = false;
        for (Game game : gamesList) {
            if (game.getGameName().equalsIgnoreCase(searchTerm)) {
                System.out.println("Game found:");
                System.out.println(game); 
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Game not found.");
        }
    }
    
     // Method to add game to the game list
    public static void addGame() {
        System.out.println("Select the type of game to add: \n1. SinglePlayer \n2. Multiplayer \n3. Tabletop Game");
        String sChoice= new Scanner(System.in).nextLine().trim();
        char choice=sChoice.charAt(0);
        
        Game newGame = null;
        switch (choice) {
            case '1': 
                newGame = new SinglePlayerGames();
                break;
            case '2': 
                newGame = new MultiplayerGames();
                break;
            case '3':
                newGame = new TabletopGames();
                break;
            default:
                System.out.println("Invalid choice. Returning to menu.");
                return;
        }
        // Set common Game attributes
        newGame.setGameName();
        newGame.setGenre();
        newGame.setAgeRate();
        newGame.setPrice();
        newGame.setDifficultyLvl();
        newGame.setReleaseDate();

        if (newGame instanceof DigitalGames digitalGame) {
            digitalGame.setPlatform();
            digitalGame.setTotalPlayTime();
            digitalGame.setDeveloper();

            if (digitalGame instanceof SinglePlayerGames singlePlayerGames) {
                singlePlayerGames.setStoryLength();
                singlePlayerGames.setIsCompleted();
                singlePlayerGames.setAutoSaveEnabled();
            } else if (digitalGame instanceof MultiplayerGames multiplayerGames) {
                multiplayerGames.setMaxPlayers();
                multiplayerGames.setRequiresMembership();
                multiplayerGames.setChatEnabled();
            }   
        }
        else if(newGame instanceof TabletopGames tabletopGame) {
            tabletopGame.setNumOfPlayers();
            tabletopGame.setGameType();
            tabletopGame.setSessionPlayTime();
            tabletopGame.setMaterial();
        }
        gamesList.add(newGame);
        System.out.println("Game added successfully! ");
    }
    
    public static void deleteGames() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the game name to delete: ");
        String searchTerm = scanner.nextLine();
        boolean found = false;

        // Search in the games list and remove
        for (int i = 0; i < gamesList.size(); i++) {
            if (gamesList.get(i).getGameName().equalsIgnoreCase(searchTerm)) {
                System.out.println(gamesList.get(i));
                gamesList.remove(i);
                System.out.println("Game deleted successfully from the Game list.");
                found = true;
                break;
            }
        }
        for (User user : User.usersList) {
            if (user instanceof Player) {
                Player player = (Player) user;
                for (int i = 0; i < player.saveList.size(); i++) {
                    if (player.saveList.get(i).getGameName().equalsIgnoreCase(searchTerm)) {
                        player.saveList.remove(i);
                        break; 
                    }
                }
            }
        }
        if (!found) {
            System.out.println("Game not found in the Game list.");
        }
    }
    
    public static void updateGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the game name to update: ");
        String searchTerm = scanner.nextLine();
        boolean found = false;
        for (Game game : gamesList) {
            if (game.getGameName().equalsIgnoreCase(searchTerm)) {
                System.out.println("Game found in the Game list:");
                System.out.println(game);

                updateGameAttributes(game);
                System.out.println("Game updated successfully in the Game list.");
                found = true;
                break;
            }
        }
        for (User user : User.usersList) {
            if (user instanceof Player) { 
                Player player = (Player) user;
                for (Game savedGame : player.saveList) {
                    if (savedGame.getGameName().equalsIgnoreCase(searchTerm)) {
                        updateGameAttributes(savedGame);
                    }
                }
            }
        }

        if (!found) {
            System.out.println("Game not found in the main list.");
        }
    }


    private static void updateGameAttributes(Game game) {
        Scanner scanner = new Scanner(System.in);
        game.setGameName();
        game.setGenre();
        game.setAgeRate();
        game.setPrice();
        game.setDifficultyLvl();
        game.setReleaseDate();
        if (game instanceof DigitalGames digitalGame) {
            digitalGame.setPlatform();
            digitalGame.setTotalPlayTime();
            digitalGame.setDeveloper();
            if (digitalGame instanceof SinglePlayerGames singlePlayerGames) {
                singlePlayerGames.setStoryLength();
                singlePlayerGames.setIsCompleted();
                singlePlayerGames.setAutoSaveEnabled();
            } else if (digitalGame instanceof MultiplayerGames multiplayerGames) {
                multiplayerGames.setMaxPlayers();
                multiplayerGames.setRequiresMembership();
                multiplayerGames.setChatEnabled();
            }
        } else if (game instanceof TabletopGames tabletopGame) {
            tabletopGame.setNumOfPlayers();
            tabletopGame.setGameType();
            tabletopGame.setSessionPlayTime();
            tabletopGame.setMaterial();
        }
    }
}// end of Game class--------------------------------------------

class DigitalGames extends Game{
    private Platform platform;
    private int totalPlayTime;
    private String developer;
    
    // Method to set platform  
    public void setPlatform() {
        while (true) {
            System.out.print("Enter platform {PC, PLAYSTATION, XBOX, NINTENDO, MOBILE} : ");
            String input = scanner.nextLine().toUpperCase().trim(); 
            boolean isValidPlatform = false; 
            for (Platform platform : Platform.values()) {
                if (platform.name().equalsIgnoreCase(input)) {
                    this.platform=platform;
                    isValidPlatform = true;
                    break;
                }   
            }
            if (isValidPlatform) {
                System.out.println("Platform set to: " + this.platform);
                break;
            } else {
                System.out.println(input + " is not a valid platform. Try again!"); 
            } 
        }
    }
    // Method to set totalPlayTime
    public void setTotalPlayTime() {
        while (true) {
            System.out.print("Enter total playtime for the game in hours : ");
            int input = Integer.parseInt(scanner.nextLine());
            if (input >= 0 && input <=100) {
                this.totalPlayTime = input;
                System.out.println("Total playtime set to: " + totalPlayTime+" hours");
                break;
            } else {
                System.out.println("Total playtime can't be negative or exceed 100 hours. Try again.");
            }   
        }
    }
    // Method to set developer
    public void setDeveloper() {
        while (true) {
            System.out.print("Enter developer name: ");
            String input = scanner.nextLine().trim();
            if (input.matches("^[A-Za-z_ ]{1,100}$")) {
                this.developer = input;
                System.out.println("Developer set to: " + developer);
                break;
            } else {
                System.out.println("Invalid developer name.");
            }
        }
    }
    // Methods to get platform, totalPlayTime and developer
    public Platform getPlatform(){return this.platform;}
    public int getTotalPlayTime(){return this.totalPlayTime;}
    public String getDeveloper(){return this.developer;}
    
    public void setPlatform(Platform platform){this.platform= platform;}
    public void setTotalPlayTime(int totalPlayTime){this.totalPlayTime= totalPlayTime;}
    public void setDeveloper(String developer){this.developer= developer;}
    
    @Override
    public String toString() {
        return super.toString()+"\n,Platform: " + this.platform +"\n,totalPlayTime: "+this.totalPlayTime+" hours"+
           "\n,Developer: " + this.developer;
    }
    public DigitalGames(){}
}//end of DigitalGames class --------------------------------------------

class TabletopGames extends Game {
    private int numOfPlayers;
    private GameType gameType;
    private int sessionPlayTime;
    private Material material;
    
    // Method to set numOfPlayers
    public void setNumOfPlayers() {
        while (true) {
            System.out.print("Enter number of players for this table top game: ");
            int input = Integer.parseInt(scanner.nextLine());
            if (input >= 0 && input<=10) {
                this.numOfPlayers = input;
                System.out.println("Number of players set to: " + this.numOfPlayers+" players.");
                break;
            } else {
                System.out.println("Number of players can't be negative or exceed 10 players. Try again.");
            }    
        }
    }
    // Method to set gameType
    public void setGameType() {
        while (true) {
            System.out.print("Enter game type (CARD, PUZZLE, BOARD, DICE): ");
            String input = scanner.nextLine().toUpperCase().trim(); 
            
            boolean isValidGameType = false;  
            
            for (GameType type : GameType.values()) {
                if (type.name().equalsIgnoreCase(input)) {
                    this.gameType = type; 
                    isValidGameType = true; 
                    break;
                }   
            }
            if (isValidGameType) {
                System.out.println("Game type set to: " + this.gameType); 
                break;
            } else {
                System.out.println(input + " is not a valid game type. Try again!");  
            } 
        } 
    }
    // Method to set sessionPlayTime
    public void setSessionPlayTime() {
        while (true) {
            System.out.print("Enter session playtime in minutes for this table top game: ");
            int input = Integer.parseInt(scanner.nextLine()); 
            if (input >= 0 && input <=240) {
                this.sessionPlayTime = input; 
                System.out.println("Session playtime set to: " + this.sessionPlayTime+" minutes.");
                break; 
            } else {
                System.out.println("Session playtime can't be negative or exceed 240 minutes (4 hours). Try again.");
            }    
        }
    }
    // Method to set materials
    public void setMaterial() {
        while (true) {
            System.out.print("Enter material (WOOD, PLASTIC, CARDBOARD, METAL, ACRYLIC, PAPER): ");
            String input = scanner.nextLine().toUpperCase().trim(); 
            boolean isValidMaterial = false;  
            for (Material mat : Material.values()) {
                if (mat.name().equalsIgnoreCase(input)) { 
                    this.material = mat; 
                    isValidMaterial = true; 
                    break;
                }   
            }
            if (isValidMaterial) {
                System.out.println("Game type set to: " + this.material); 
                break;
            } else {
                System.out.println(input + " is not a valid material. Try again!");  
            } 
        }
    }
    // get methods for numOfPlayers, gameType,sessionPlayTime and materials
    public int getNumOfPlayers(){return this.numOfPlayers;}
    public GameType getGameType(){return this.gameType;}
    public int getSessionPlayTime(){return this.sessionPlayTime;}
    public Material getMaterials(){return this.material;}
    
    public void setNumOfPlayers(int numOfPlayers){this.numOfPlayers= numOfPlayers;}
    public void setGameType(GameType gameType){this.gameType= gameType;}
    public void setSessionPlayTime(int sessionPlayTime){this.sessionPlayTime= sessionPlayTime;}
    public void setMaterials(Material material){this.material= material;}
    
    @Override
    public String toString() {
        return super.toString()+"\n,Num of players: " + this.numOfPlayers +" players"+"\n,Game type: "+this.gameType+
           "\n,Session play time: "+ this.sessionPlayTime+" minutes"+"\n,material: " + this.material;
    }
    public TabletopGames(){}
    
}//end of TabletopGames class ------------------------------------

class SinglePlayerGames extends DigitalGames {
    private int storyLength;
    private boolean isCompleted;
    private boolean autoSaveEnabled;
    
    // method to set storyLength
    public void setStoryLength() {
        while (true) {
        System.out.print("Enter story length(hours needed to complete the story): ");
        int input = Integer.parseInt(scanner.nextLine());
        if (input >= 0 && input <=100) {
            this.storyLength = input;
            System.out.println("Story length set to: " + this.storyLength+" hours.");
            break;
        } else {
            System.out.println("Story length can't be negative or exceed 100 hours. Try again.");
            }  
        }
    }
    // method to set isCompleted
    public void setIsCompleted() {
        while (true) {
            System.out.print("Is the game completed? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                this.isCompleted = true;
                System.out.println("Game completion status set to: Completed");
                break;
            } else if (input.equals("no")) {
                this.isCompleted = false;
                System.out.println("Game completion status set to: Not Completed");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }  
        }
    }
    // method to set autoSaveEnabled
    public void setAutoSaveEnabled() {
        while (true) {
            System.out.print("Is auto-save enabled in this game? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                this.autoSaveEnabled = true;
                System.out.println("Auto-save status set to: Enabled");
                break;
            } else if (input.equals("no")) {
                this.autoSaveEnabled = false;
                System.out.println("Auto-save status set to: Disabled");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }   
        }
    }
    //Methods to get storyLength, isCompleted and autoSaveEnabled
    public int getStoryLength(){return this.storyLength;}
    public boolean getIsCompleted(){return this.isCompleted;}
    public boolean getAutoSaveEnabled(){return this.autoSaveEnabled;}
    
    public void setStoryLength(int storyLength){this.storyLength= storyLength;}
    public void setIsCompleted(boolean isCompleted){this.isCompleted= isCompleted;}
    public void setAutoSaveEnabled(boolean autoSaveEnabled){this.autoSaveEnabled= autoSaveEnabled;}
    
    @Override
    public String toString() {
        String completed= (this.isCompleted)?"Completed":"Not completed";
        String autoSave=(this.autoSaveEnabled)?"is Enabled": "is Disabled";
        return super.toString()+"\n,Story length: " + this.storyLength +" hours"+"\n,Game is: "+completed+
           "\n,Auto save: " +autoSave;
    }
    public SinglePlayerGames(){}
    
}//end of SinglePlayer class----------------------------------------

class MultiplayerGames extends DigitalGames {
    private int maxPlayers;
    private boolean chatEnabled;
    private boolean requiresMembership;
    
    //method to set maxPlayers
    public void setMaxPlayers() {
        while (true) {
            System.out.print("Enter max players from(1 to 4): ");
            int input = Integer.parseInt(scanner.nextLine());
            if (input >=1 && input <= 4 ) {
                maxPlayers = input;
                System.out.println("Max players set to: " + maxPlayers+" players");
                break;
            } else {
                System.out.println("Max players must be from 1 to 4. Try again.");
            }   
        }
    }
    // method to set chatEnabled
    public void setChatEnabled() {
        while (true) {
            System.out.print("Is chat enabled in this game? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                chatEnabled = true;
                System.out.println("chat status set to: Enabled");
                break;
            } else if (input.equals("no")) {
                chatEnabled = false;
                System.out.println("chat status set to: Disabled");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }   
        }
    }
    // method to set requiresMembership
    public void setRequiresMembership() {
        while (true) {
            System.out.print("does this game require Membership? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                requiresMembership = true;
                System.out.println("game is set to 'requires Membership' to play");
                break;
            } else if (input.equals("no")) {
                requiresMembership = false;
                System.out.println("game is set to 'doesn't require Membership' to play");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }  
        }
    }
    
    //Methods to get maxPlayers, chatEnabled and requiresMembership
    public int getMaxPlayers(){return this.maxPlayers;}
    public boolean getChatEnabled(){return this.chatEnabled;}
    public boolean getRequiresMembership(){return this.requiresMembership;}
    
    public void setMaxPlayers(int maxPlayers){this.maxPlayers= maxPlayers;}
    public void setChatEnabled(boolean chatEnabled) {this.chatEnabled= chatEnabled;}
    public void setRequiresMembership(boolean requiresMembership){this.requiresMembership= requiresMembership;}
    
    @Override
    public String toString() {
        String membership= (this.requiresMembership)?"is required":"is not required";
        String chat=(this.chatEnabled)?"is Enabled": "is Disabled";
        return super.toString()+"\n,maxPlayers: " + this.maxPlayers +" players"+"\n,Chat: "+chat+
           "\n,Membership: " + membership;
    }
    public MultiplayerGames(){}
    
}//end of Multiplayer class--------------------------------------

class User {
    private String username;
    private String password;
    private char userType;
    public static boolean login;
    
    protected static Scanner scanner = new Scanner(System.in);
    protected static ArrayList<User> usersList = new ArrayList<>();
    
    public static void initializeUsers(){
        Developer user1 = new Developer();
        user1.setUsername("Reema");
        user1.setPassword("Reema219");
        user1.setUserType('D');
        user1.setStudio("Rain");
        usersList.add(user1);
        
        Developer user2 = new Developer();
        user2.setUsername("Sahar");
        user2.setPassword("Sahar111");
        user2.setUserType('D');
        user2.setStudio("Jafar");
        usersList.add(user2);
        
        Developer user3 = new Developer();
        user3.setUsername("Ghala");
        user3.setPassword("Ghala111");
        user3.setUserType('D');
        user3.setStudio("ping");
        usersList.add(user3);
        
        Player user4 = new Player();
        user4.setUsername("Judee");
        user4.setPassword("Jude1111");
        user4.setUserType('P');
        usersList.add(user4);
        
        Player user5 = new Player();
        user5.setUsername("Zahraa");
        user5.setPassword("Zahraa11");
        user5.setUserType('P');
        usersList.add(user5);
        
        Player user6 = new Player();
        user6.setUsername("Nematallah");
        user6.setPassword("Nemat111");
        user6.setUserType('P');
        usersList.add(user6);
        
    }
    
    // method to set username
    public void setUsername() {
        while (true) {
            System.out.print("Enter username (5 to 20 characters): ");
            String usernameInput = scanner.nextLine().trim();
            boolean usernameExists = false;
            
            for (User user : usersList) {
                if (user.getUsername().equals(usernameInput)) {
                    usernameExists=true;
                    break;   
                }
            }
            if (usernameExists){
               System.out.println("Username already exists. Please choose a different username.");
            } else if (usernameInput.matches("[A-Za-z0-9_]{5,20}")) {
                this.username = usernameInput;
                break;
            } else {
                System.out.println("Invalid username. It must be between 5 to 20 characters,include letters, numbers and underscores only.");
            } 
        }
    }
    // method to Set Password
    public void setPassword() {
        while (true) {
            System.out.print("Enter password: ");
            String input = scanner.nextLine();
            if (input.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z0-9_]{8,}$")) {
                this.password = input;
                break;
            } else {
                System.out.println("Invalid password. It must be at least 8 characters,include letters, numbers and underscores only.");
            }
        }
    }
   
    // methods to get username,password and User type
    public String getUsername() {return this.username;}
    public String getPassword() {return this.password;}
    public char getUserType(){return this.userType;}
    
    public void setUsername(String username) {this.username= username;}
    public void setPassword(String password) {this.password= password;}
    public void setUserType(char userType) {this.userType=userType;}
   
    public static User manageUsers() {
        User currentUser=null;
        while (true){
            System.out.println("Choose from menu: \n1.sign-in \n2.Login \n0.exit");
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":{
                    signIn();
                    break;
                }
                case "2":{
                    currentUser=logIn();
                    if(currentUser != null){
                        return currentUser;
                    }
                    break;
                }
                case "0":
                    return null;
                
                default:
                    System.out.println("Invalid choice. Try again.");
            }  
        }
    }
    // Sign In Method
    public static void signIn() {
        User newUser;
       
        while (true) {
            System.out.print("Enter user type (D for Developer, P for Player): ");
            String sUserType = scanner.nextLine().trim().toUpperCase();
            if (sUserType.length() != 1){
                System.out.println("Invalid user type. must be 1 character try again.");
                continue;
            }
            char userType=sUserType.charAt(0);
            if (userType == 'D') {
                newUser = new Developer();
                newUser.setUserType('D');
                break;
            } else if (userType == 'P') {
                newUser = new Player(); 
                newUser.setUserType('P');
                break;
            } else {
                System.out.println("Invalid user type. Try again.");
            }
        }
        newUser.setUsername();
        newUser.setPassword();
        if (newUser instanceof Developer) {
            ((Developer) newUser).setStudio();
        }
        usersList.add(newUser);
        System.out.println("User signed in successfully!");
    }
    // Log In Method
    public static User logIn() {
        System.out.print("Enter username: ");
        String usernameInput = scanner.nextLine().trim();
        User existingUser = null;
        for (User user : usersList) {
            if (user.getUsername().equals(usernameInput)) {
                existingUser = user;
                break;
            }
        }
        
        if (existingUser == null) {
            System.out.println("Username does not exist.");
            return null;
        }
        System.out.print("Enter password: ");
        String passwordInput = scanner.nextLine();
        
        if (!existingUser.password.equals(passwordInput)) {
            System.out.println("Incorrect password.");
            return null;
        }
        System.out.println("Logged in successfully as " +(existingUser instanceof Developer ? "Developer" : "Player") + "!");
        login=true;
        return existingUser; 
    }   
    
    public static void Menu() {
        
        boolean exitProgram = false;
        
        while (!exitProgram) {
        
            User currentUser = User.manageUsers(); 
            
            if (currentUser == null) {
                System.out.println("Exiting GameExplore!");
                exitProgram=true;
                break; // Exit the program    
            } 
            
            boolean returnToMainMenu = false;
            
            while(!returnToMainMenu){
                if (currentUser.getUserType() == 'D') {
                    Developer.developerMenu();
                    returnToMainMenu = true; 
                } else if (currentUser.getUserType() == 'P') {
                    ((Player) currentUser).playerMenu();
                    returnToMainMenu = true; 
                } else {
                    System.out.println("Invalid user type. Returning to main menu.");
                    returnToMainMenu = true; 
                }
            }
        }
    }
}//end of user class-----------------------------------------------

class Player extends User {
    ArrayList<Game> saveList = new ArrayList<>();
    public Player() {}

    public void playerMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Player Menu ---");
            System.out.println("1. Search Games");
            System.out.println("2. Display All Games");
            System.out.println("3. Display Save List");
            System.out.println("4. Add Game to Save List");
            System.out.println("5. Delete Game from Save List");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            
            String sChoice=scanner.nextLine().trim();
            
            char choice=sChoice.charAt(0);
            
            

            switch (choice) {
                case '1':{
                    Game.searchGames();
                    break;}
                case '2':{
                    Game.displayAllGames();
                    break;}
                case '3':{
                    this.displaySaveList();
                    break;}
                case '4':{
                    this.addToSaveList(scanner);
                    break;}
                case '5':{
                    this.deleteFromSaveList(scanner);
                    break;}
                case '0':{
                    System.out.println("Exiting Player Menu.");
                    return;}
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    public void displaySaveList(){
        if (this.saveList.isEmpty()){
            System.out.println("Save list is empty.");
        } else {
            System.out.println("Saved Games:");
            int index=1;
            for (Game game : this.saveList) {
                System.out.println("--------------------------------------------");
                System.out.println(index++ + "." + game);
            }
        }
    }
    public void addToSaveList(Scanner scanner){
        System.out.print("Enter the game name to add to savelist: ");
        String gameName = scanner.nextLine();
        for (Game savedGame : saveList) {
            if (savedGame.getGameName().equalsIgnoreCase(gameName)) {
                System.out.println("Game is already in the save list.");
                return; 
            }
        }
        for (Game game : Game.gamesList) {
            if (game.getGameName().equalsIgnoreCase(gameName)) {
                saveList.add(game);
                System.out.println("Game added to save list.");
                return;
            }
        }
        System.out.println("Game not found.");  
    }
    public void deleteFromSaveList(Scanner scanner){
        System.out.print("Enter the game name to remove from save list: ");
        String gameName = scanner.nextLine();
        boolean gameFound = false;
        for (Game game : Game.gamesList) {
            if (game.getGameName().equalsIgnoreCase(gameName)) {
                saveList.remove(game);
                System.out.println("Game removed from save list.");
                gameFound=true;
                return;
            }
        }if (!gameFound) {
        System.out.println("Game not found in save list.");
        }
    }  
}// end of Player class --------------------------------------------------------------

class Developer extends User{
    private String studio;
    
    public void setStudio() {
        while (true) {
            System.out.print("Enter the studio name: ");
            String input = scanner.nextLine();
            if (input.matches("^[A-Za-z0-9_]{1,100}$")) {
                studio = input;
                break;
            } else {
                System.out.println("Invalid studio name. Try again.");
            }
        }
    }
    public String getStudio(){return this.studio;}
    
    public void setStudio(String studio){this.studio = studio;}
     
    public static void developerMenu() {
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Developer Menu ---");
            System.out.println("1. Add Game");
            System.out.println("2. Display Games");
            System.out.println("3. Delete a Game");
            System.out.println("4. Upadte a Game");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            
            String sChoice=scanner.nextLine().trim();
            
            char choice=sChoice.charAt(0);

            switch (choice) {
                case '1':
                    Game.addGame();
                    break;
                case '2':
                    Game.displayAllGames();
                    break;
                case '3':
                    Game.deleteGames();
                    break;
                case'4':
                    Game.updateGame();
                    break;   
                case '0':
                    System.out.println("Exiting Developer Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
   
    public Developer(){} 
}//end of Developer class-----------------------------------------

public class GameExplore {
    public static void main(String[] args) {    
        Game.initializeGames();
        User.initializeUsers();
        System.out.println("Welcome to Gamexplore!!");
        User.Menu();   
    }  
}
