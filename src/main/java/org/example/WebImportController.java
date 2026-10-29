package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebImportController {

    private static final int TIMEOUT_MS = 8000; // 8-second network timeout
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36";


    public Recipe extractRecipeFromURL(String recipeUrl) throws IOException {
        if (!validateURL(recipeUrl)) {
            throw new IllegalArgumentException("Invalid URL format provided: " + recipeUrl);
        }

        // 2. Establish HTTP Connection & Download Document
        Document doc = Jsoup.connect(recipeUrl)
                .userAgent(USER_AGENT)
                .timeout(TIMEOUT_MS)
                .get();

        // 3. Extract Core Metadata
        String title = parseRecipeTitle(doc);
        List<RecipeIngredient> ingredients = parseIngredients(doc);
        List<String> instructions = parseInstructions(doc);

        // 4. Construct and Return Model Object
        Recipe recipe = new Recipe();
        recipe.setRecipeName(title);
        recipe.setIngredients(ingredients);
        recipe.setSteps(instructions);
        recipe.setDescription("Imported from: " + recipeUrl);
        recipe.setServings(4); // Default baseline serving size

        return recipe;
    }

    /**
     * Validates whether a given string is a correctly formatted HTTP/HTTPS URL.
     */
    public boolean validateURL(String urlString) {
        if (urlString == null || urlString.trim().isEmpty()) {
            return false;
        }
        try {
            URL url = new URL(urlString);
            String protocol = url.getProtocol();
            return "http".equalsIgnoreCase(protocol) || "https".equalsIgnoreCase(protocol);
        } catch (MalformedURLException e) {
            return false;
        }
    }

    /**
     * Extracts recipe title using common fallback CSS selectors.
     */
    private String parseRecipeTitle(Document doc) {
        // Common CSS selectors used across major cooking blogs
        String[] titleSelectors = { "h1.recipe-title", "h1.entry-title", "h1.fn", "h1" };
        for (String selector : titleSelectors) {
            Element titleElement = doc.selectFirst(selector);
            if (titleElement != null && !titleElement.text().trim().isEmpty()) {
                return titleElement.text().trim();
            }
        }
        return "Untitled Scraped Recipe";
    }

    /**
     * Parses ingredient list elements from HTML DOM structure.
     */
    private List<RecipeIngredient> parseIngredients(Document doc) {
        List<RecipeIngredient> list = new ArrayList<>();
        // Select elements matching standard ingredient list classes
        Elements ingredientElements = doc.select("ul.recipe-ingredients li, li.ingredient, div.ingredient");

        for (Element elem : ingredientElements) {
            String rawLine = elem.text().trim();
            if (!rawLine.isEmpty()) {
                // Instantiate generic placeholder model for UI customization
                Ingredient baseIng = new Ingredient(0, rawLine, "unit", "General", 0.0, 0.0, 0.0, 0.0);
                RecipeIngredient recIng = new RecipeIngredient(0, 0, baseIng, 1.0, "item", rawLine);
                list.add(recIng);
            }
        }
        return list;
    }

    /**
     * Parses procedural cooking instruction steps from HTML DOM structure.
     */
    private List<String> parseInstructions(Document doc) {
        List<String> steps = new ArrayList<>();
        Elements stepElements = doc.select("ol.recipe-steps li, ul.instructions li, div.step");

        for (Element stepElem : stepElements) {
            String stepText = stepElem.text().trim();
            if (!stepText.isEmpty()) {
                steps.add(stepText);
            }
        }
        return steps;
    }
}
