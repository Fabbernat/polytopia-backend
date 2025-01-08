# main.py

from polytopia_score_counter.rewards import calculate_reward
from polytopia_score_counter.actions import ACTIONS

def main():
    # Test reward calculations
    print("Reward for training an archer:", calculate_reward("train_unit", unit_type="archer"))
    print("Reward for losing a warrior:", calculate_reward("lose_unit", unit_type="warrior"))
    print("Reward for upgrading a city with 3 population gain:", calculate_reward("upgrade_city", city_population_gain=3))
    print("Reward for placing a monument:", calculate_reward("place_structure", structure="monument"))
    print("Reward for researching a Tier 2 technology:", calculate_reward("research_tech", tech_tier=2))
    print("Reward for discovering a fog tile:", calculate_reward("discover_fog"))
    print("Reward for gaining a territory tile:", calculate_reward("gain_territory"))
    print("Reward for losing a city with 2 population:", calculate_reward("lose_city", city_population_loss=2))

if __name__ == "__main__":
    main()
