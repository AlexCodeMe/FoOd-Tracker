-- Dummy data for Account
INSERT INTO account (id, user_id, account_type, roles) VALUES
(1, 1, 'premium', 'ROLE_USER'),
(2, 2, 'free', 'ROLE_USER');

-- Dummy data for User (with hashed passwords)
INSERT INTO user (id, username, email, password_hash, created_at, updated_at) VALUES
(1, 'alex123', 'alex@example.com', '$2a$10$yWxP0t1z9cEzmzz.pYyyMuU8IWdVOMDQE7bUmfIoA0z7gS8b4xlkO', NOW(), NOW()), -- password: 'password1'
(2, 'john_doe', 'john@example.com', '$2a$10$wUuD/A8HITe0v/AEqKpS1uQ9PWi3BEdXUjz/Wr62v.TO.bAtS1iYy', NOW(), NOW()); -- password: 'password2'

-- Dummy data for Meal
INSERT INTO meal (id, user_id, date, time, name) VALUES
(1, 1, '2024-09-15', '12:30:00', 'Lunch'),
(2, 1, '2024-09-15', '08:00:00', 'Breakfast'),
(3, 2, '2024-09-15', '19:00:00', 'Dinner');

-- Dummy data for MealFood
INSERT INTO meal_food (id, meal_id, food_id, portion_size, unit) VALUES
(1, 1, 1, 150, 'g'),
(2, 2, 2, 1, 'slice'),
(3, 3, 3, 200, 'ml');

-- Dummy data for Food
INSERT INTO food (id, name, fdc_id, is_custom, calories, protein, carbs, fat) VALUES
(1, 'Grilled Chicken', 12345, FALSE, 200, 30, 0, 10),
(2, 'Toast', 12346, FALSE, 100, 4, 20, 1),
(3, 'Orange Juice', 12347, FALSE, 80, 1, 18, 0);

-- Dummy data for FoodNutrient
INSERT INTO food_nutrient (id, food_id, nutrient_id, amount) VALUES
(1, 1, 1, 30), -- protein
(2, 2, 2, 20), -- carbs
(3, 3, 3, 18); -- carbs

-- Dummy data for Nutrient
INSERT INTO nutrient (id, name, unit) VALUES
(1, 'Protein', 'g'),
(2, 'Carbohydrates', 'g'),
(3, 'Fat', 'g');

-- Dummy data for Recipe
INSERT INTO recipe (id, user_id, name, instructions, servings) VALUES
(1, 1, 'Grilled Chicken Salad', '1. Grill chicken\n2. Mix with salad', 2),
(2, 2, 'Pasta', '1. Boil pasta\n2. Add sauce', 4);

-- Dummy data for RecipeIngredient
INSERT INTO recipe_ingredient (id, recipe_id, food_id, amount, unit) VALUES
(1, 1, 1, 150, 'g'), -- Chicken
(2, 2, 2, 200, 'g'); -- Pasta

-- Dummy data for NutritionGoal
INSERT INTO nutritional_goal (id, user_id, nutrient_id, target_amount, frequency) VALUES
(1, 1, 1, 100, 'daily'), -- Protein goal
(2, 2, 2, 250, 'weekly'); -- Carb goal

-- Dummy data for DietaryPreference
INSERT INTO dietary_preference (id, user_id, is_vegan, is_vegetarian, is_keto, allergies) VALUES
(1, 1, FALSE, TRUE, FALSE, 'None'),
(2, 2, FALSE, FALSE, TRUE, 'Peanuts');

-- Dummy data for WaterIntakeRecord
INSERT INTO water_intake_record (id, user_id, date, amount) VALUES
(1, 1, '2024-09-15', 2000),
(2, 2, '2024-09-15', 1500);

-- Dummy data for ExportLog
INSERT INTO export_log (id, user_id, export_date, file_type, file_path) VALUES
(1, 1, '2024-09-15 12:30:00', 'csv', '/path/to/file1.csv'),
(2, 2, '2024-09-15 12:30:00', 'json', '/path/to/file2.json');
