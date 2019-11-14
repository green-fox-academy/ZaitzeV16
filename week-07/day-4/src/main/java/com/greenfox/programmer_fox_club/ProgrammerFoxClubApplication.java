package com.greenfox.programmer_fox_club;

import com.greenfox.programmer_fox_club.models.Drink;
import com.greenfox.programmer_fox_club.models.Food;
import com.greenfox.programmer_fox_club.models.Fox;
import com.greenfox.programmer_fox_club.models.Trick;
import com.greenfox.programmer_fox_club.services.DrinkServiceImpl;
import com.greenfox.programmer_fox_club.services.FoodServiceImpl;
import com.greenfox.programmer_fox_club.services.FoxServiceImpl;
import com.greenfox.programmer_fox_club.services.TrickServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgrammerFoxClubApplication implements CommandLineRunner {

  // region Fields
  private FoxServiceImpl foxService;
  private FoodServiceImpl foodService;
  private DrinkServiceImpl drinkService;
  private TrickServiceImpl trickService;
  // endregion Fields


  // region Constructors
  @Autowired
  public ProgrammerFoxClubApplication(
      FoxServiceImpl foxService,
      FoodServiceImpl foodService,
      DrinkServiceImpl drinkService,
      TrickServiceImpl trickService) {
    this.foxService = foxService;
    this.foodService = foodService;
    this.drinkService = drinkService;
    this.trickService = trickService;
  }
  // endregion Constructors

  public static void main(String[] args) {
    SpringApplication.run(ProgrammerFoxClubApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    Fox fox1 = new Fox("Kajak");
    Fox fox2 = new Fox("Lófasz");
    Fox fox3 = new Fox("BélaNéni");

    Food kaja1 = new Food("METÁL");
    Food kaja2 = new Food("mitmivan");
    Food kaja3 = new Food("NEIN");

    Drink pia1 = new Drink("MÖTÁL");
    Drink pia2 = new Drink("gáááááááácó");
    Drink pia3 = new Drink("lötykölő");

    Trick trick1 = new Trick("baszass egy szaltót");
    Trick trick2 = new Trick("kajakozz");
    Trick trick3 = new Trick("takarodj");

    this.trickService.save(trick1);
    this.trickService.save(trick2);
    this.trickService.save(trick3);

    fox1.setDrink(pia1);
    fox1.setFood(kaja1);
    this.foxService.save(fox1);

    fox2.setDrink(pia2);
    fox2.setFood(kaja2);
    this.foxService.save(fox2);

    fox3.setDrink(pia3);
    fox3.setFood(kaja3);
    this.foxService.save(fox3);

//    fox1.getTricks().add(this.trickService.findById(1));
//    fox1.getTricks().add(this.trickService.findById(2));
//    this.foxService.save(fox1);
//    fox1.getTricks().add(this.trickService.findById(3));
//    this.foxService.save(fox1);

    this.foxService.learnTrick(fox1, this.trickService.findById(1));
    this.foxService.learnTrick(fox1, this.trickService.findById(2));
    this.foxService.learnTrick(fox1, this.trickService.findById(3));

//    this.foxService.learnTrick(fox1, trick1);
//    this.foxService.learnTrick(fox1, trick2);
//    this.foxService.learnTrick(fox1, trick3);

  }
}
