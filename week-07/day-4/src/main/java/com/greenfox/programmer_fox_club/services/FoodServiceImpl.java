package com.greenfox.programmer_fox_club.services;

import com.greenfox.programmer_fox_club.models.Food;
import com.greenfox.programmer_fox_club.repositories.FoodRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

  // region Fields
  private FoodRepository foodRepository;
  // endregion Fields


  // region Constructors
  public FoodServiceImpl() {
  }

  @Autowired
  public FoodServiceImpl(FoodRepository foodRepository) {
    this.foodRepository = foodRepository;
  }
  // endregion Constructors


  // region FindBy
  @Override
  public Food findById(long id) {
    return this.foodRepository.findById(id).orElse(null);
  }

  @Override
  public Food findByName(String petName) {
    return this.foodRepository.findByName(petName);
  }
  // endregion FindBy


  // region FindAllBy
  @Override
  public List<Food> findAllBy() {
    List<Food> foodList = new ArrayList<>();
    this.foodRepository.findAll().forEach(foodList::add);
    return foodList;
  }
  // endregion FindAllBy


  // region SaveUpdate
  @Override
  public void save(Food food) {
    this.foodRepository.save(food);
  }
  // endregion SaveUpdate

}
