package com.shavemax.shavemax.restcontroller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shavemax.shavemax.aspect.ValidateToken;
import com.shavemax.shavemax.enums.RoleEnum;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hairstyles")
public class HairstylesController {

    private static final String HAIRSTYLES_JSON = """
        [
          {
            "id": 1,
            "name": "Undercut with Comb Over",
            "description": "Provides a clean and sharp look that contrasts with the jawline. The sides are kept short while the top is left longer and combed over for a polished appearance.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 2,
            "name": "Side Part",
            "description": "Adds asymmetry, softening the square features. The hair is parted to one side, creating a classic and sophisticated look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 3,
            "name": "Textured Crop",
            "description": "Adds volume and texture, reducing the boxiness of a square face. The hair is cut in short, choppy layers that add movement.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 4,
            "name": "Messy Quiff",
            "description": "Adds height and texture, drawing attention upwards. This style is slightly tousled for a casual yet stylish appearance.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 5,
            "name": "Wavy Side Swept",
            "description": "Balances the strong jawline with soft waves. The hair is swept to one side, creating a relaxed and sophisticated look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 6,
            "name": "Curly Fringe",
            "description": "Softens the angles with natural wave patterns. The fringe is left longer and styled to create a wavy, textured look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 7,
            "name": "Curly Top with Tapered Sides",
            "description": "Keeps the curls manageable and stylish. The sides are tapered short while the top is left longer to showcase natural curls.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 8,
            "name": "Short Afro",
            "description": "Maintains the natural curl pattern, emphasizing the round shape without overwhelming it. This style keeps the curls tight and neat.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 9,
            "name": "Curly Undercut",
            "description": "Contrasts the tight curls on top with short sides. This style is trendy and highlights the natural curls.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 10,
            "name": "Pompadour",
            "description": "Adds volume on top, balancing the face length. This style is characterized by its height and slicked-back appearance.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 11,
            "name": "Side Part with Fade",
            "description": "Adds width to the face, making it look less elongated. The fade creates a clean contrast between the sides and the longer top.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 12,
            "name": "Buzz Cut",
            "description": "Creates a balanced and uniform look. This ultra-short haircut is easy to maintain and emphasizes facial features.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 13,
            "name": "Wavy Pompadour",
            "description": "Combines volume and texture, ideal for a rectangular face. This style keeps the natural wave while adding height.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 14,
            "name": "Loose Waves with Tapered Sides",
            "description": "Keeps the focus on the hair without elongating the face. The sides are tapered short while the top remains wavy.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 15,
            "name": "Shaggy Layers",
            "description": "Adds width and softens the long face shape. The hair is cut in layers to enhance the natural wave and add volume.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 16,
            "name": "Curly Pompadour",
            "description": "Adds height and dimension without elongating the face. The curls are styled upwards and back.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 17,
            "name": "Medium Length Curls",
            "description": "Provides volume and balance to the face. The curls are left at medium length for a natural, voluminous look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 18,
            "name": "Curly Fringe with Undercut",
            "description": "Keeps curls manageable and adds width to the face. The undercut contrasts with the curly fringe on top.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 19,
            "name": "Classic Taper",
            "description": "A timeless cut that complements the balanced proportions. The sides are tapered short, and the top is left slightly longer.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 20,
            "name": "Textured Pompadour",
            "description": "Adds volume without elongating the face. The hair is styled upwards and back with added texture.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 21,
            "name": "Crew Cut",
            "description": "Simple and neat, maintaining the natural balance. This short haircut is easy to maintain and suits an oval face well.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 22,
            "name": "Wavy Fringe",
            "description": "Adds texture and keeps the face looking balanced. The fringe is left longer and styled to enhance the natural wave.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 23,
            "name": "Tousled Waves",
            "description": "Enhances the natural wave pattern for a casual look. The hair is left at medium length and tousled for texture.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 24,
            "name": "Medium Length Shag",
            "description": "Softens the features and adds texture. The hair is cut in layers to enhance the wave and create a shaggy look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 25,
            "name": "Curly Caesar Cut",
            "description": "Keeps curls tight and manageable. The hair is cut short with a slight fringe.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 26,
            "name": "Curly Quiff",
            "description": "Adds height and texture, complementing the oval shape. The curls are styled upwards and back.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 27,
            "name": "Medium Length Curls with Tapered Sides",
            "description": "Balances the face with volume and control. The sides are tapered short while the curls are left at medium length.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 28,
            "name": "Pompadour",
            "description": "Adds volume on top, balancing the face length. This style is characterized by its height and slicked-back appearance.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 29,
            "name": "Side Part with Fade",
            "description": "Adds width to the face, making it look less elongated. The fade creates a clean contrast between the sides and the longer top.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 30,
            "name": "Buzz Cut",
            "description": "Creates a balanced and uniform look. This ultra-short haircut is easy to maintain and emphasizes facial features.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 31,
            "name": "Wavy Pompadour",
            "description": "Combines volume and texture, ideal for a rectangular face. This style keeps the natural wave while adding height.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 32,
            "name": "Loose Waves with Tapered Sides",
            "description": "Keeps the focus on the hair without elongating the face. The sides are tapered short while the top remains wavy.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 33,
            "name": "Shaggy Layers",
            "description": "Adds width and softens the long face shape. The hair is cut in layers to enhance the natural wave and add volume.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 34,
            "name": "Curly Pompadour",
            "description": "Adds height and dimension without elongating the face. The curls are styled upwards and back.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 35,
            "name": "Medium Length Curls",
            "description": "Provides volume and balance to the face. The curls are left at medium length for a natural, voluminous look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 36,
            "name": "Curly Fringe with Undercut",
            "description": "Keeps curls manageable and adds width to the face. The undercut contrasts with the curly fringe on top.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 37,
            "name": "Long Layers",
            "description": "Adds softness and movement, reducing the angularity of a square face. The layers create a cascading effect that flatters the jawline.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 38,
            "name": "Blunt Bob",
            "description": "Emphasizes the sharp features of a square face with a sleek and sophisticated look. The length is usually just below the chin, enhancing the jawline.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 39,
            "name": "Side-Swept Bangs",
            "description": "Softens the forehead and adds a touch of asymmetry to balance the square shape. The bangs are swept to one side, creating a gentle frame for the face.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 40,
            "name": "Beach Waves",
            "description": "Adds a soft, tousled look that breaks up the strong lines of a square face. The natural waves create volume and movement.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 41,
            "name": "Shaggy Lob",
            "description": "Combines layers and waves for a textured look that adds dimension and softness to a square face. The lob length falls around the collarbone.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 42,
            "name": "Wavy Pixie Cut",
            "description": "Adds a playful and chic element to the square face. The waves create a soft texture that contrasts with the structured shape.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 43,
            "name": "Curly Bob",
            "description": "The curls add volume and texture, softening the angles of a square face. The bob length enhances the jawline while adding movement.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 44,
            "name": "Curly Shag",
            "description": "Features layers and curls for a voluminous and textured look. This style breaks up the strong lines of a square face, adding softness.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 45,
            "name": "Long Curly Layers",
            "description": "Adds length and volume, drawing attention away from the jawline. The curls create a soft and romantic look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 46,
            "name": "Long Layers with Side Part",
            "description": "Adds volume at the bottom to balance the wider forehead and narrower chin. The side part softens the forehead.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 47,
            "name": "Chin-Length Bob",
            "description": "Balances the face shape by adding volume around the chin area. This length is perfect for highlighting the jawline.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 48,
            "name": "Curtain Bangs",
            "description": "Softens the forehead and draws attention to the eyes. The bangs part in the middle and frame the face nicely.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 49,
            "name": "Textured Lob",
            "description": "Adds body and movement, softening the chin and balancing the forehead. The waves create a relaxed and stylish look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 50,
            "name": "Wavy Bob with Bangs",
            "description": "Adds volume around the chin and softens the forehead with bangs. The waves add texture and dimension.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 51,
            "name": "Boho Waves",
            "description": "Creates a soft, tousled look that balances the heart-shaped face. The waves add a carefree and feminine touch.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 52,
            "name": "Curly Bob",
            "description": "Adds volume and balances the face by drawing attention away from the forehead. The curls create a playful and chic look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 53,
            "name": "Curly Lob",
            "description": "Adds length and volume, creating a balanced look. The curls enhance the overall volume and add a fun texture.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 54,
            "name": "Curly Pixie",
            "description": "Highlights the natural curl pattern and creates a voluminous top, balancing the face shape. The sides are kept short for contrast.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 55,
            "name": "Long Layers",
            "description": "Adds softness and movement, reducing the angularity of a square face. The layers create a cascading effect that flatters the jawline.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 56,
            "name": "Blunt Bob",
            "description": "Emphasizes the sharp features of a square face with a sleek and sophisticated look. The length is usually just below the chin, enhancing the jawline.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 57,
            "name": "Side-Swept Bangs",
            "description": "Softens the forehead and adds a touch of asymmetry to balance the square shape. The bangs are swept to one side, creating a gentle frame for the face.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 58,
            "name": "Beach Waves",
            "description": "Adds a soft, tousled look that breaks up the strong lines of a square face. The natural waves create volume and movement.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 59,
            "name": "Shaggy Lob",
            "description": "Combines layers and waves for a textured look that adds dimension and softness to a square face. The lob length falls around the collarbone.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 60,
            "name": "Wavy Pixie Cut",
            "description": "Adds a playful and chic element to the square face. The waves create a soft texture that contrasts with the structured shape.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 61,
            "name": "Curly Bob",
            "description": "The curls add volume and texture, softening the angles of a square face. The bob length enhances the jawline while adding movement.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 62,
            "name": "Curly Shag",
            "description": "Features layers and curls for a voluminous and textured look. This style breaks up the strong lines of a square face, adding softness.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 63,
            "name": "Long Curly Layers",
            "description": "Adds length and volume, drawing attention away from the jawline. The curls create a soft and romantic look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 64,
            "name": "Long Layers",
            "description": "Adds volume and movement, breaking up the length of an oblong face. The layers start around the chin, creating a balanced look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 65,
            "name": "Blunt Bangs",
            "description": "Shortens the appearance of an oblong face by covering the forehead. Blunt bangs add a chic and youthful touch.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 66,
            "name": "Shoulder-Length Cut",
            "description": "Adds width around the face and draws attention to the collarbone, balancing the long face shape.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 67,
            "name": "Wavy Lob",
            "description": "Adds volume and texture, breaking up the length of an oblong face. The waves create a soft and feminine look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 68,
            "name": "Side-Swept Waves",
            "description": "Adds volume and movement to one side, creating an asymmetrical look that shortens the face.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 69,
            "name": "Beach Waves",
            "description": "Adds a relaxed and tousled look, breaking up the length and adding softness.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 70,
            "name": "Curly Bob",
            "description": "Adds volume and width, balancing the length of an oblong face. The curls create a playful and chic look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 71,
            "name": "Curly Lob",
            "description": "Adds length and volume, breaking up the vertical lines of an oblong face. The curls create a soft and voluminous look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 72,
            "name": "Long Curly Layers",
            "description": "Adds volume and movement, drawing attention away from the length of the face. The layers create a soft and flowing look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 73,
            "name": "Long Layers",
            "description": "Adds length and balances the width of a round face. The layers start around the chin, creating a slimming effect.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 74,
            "name": "Blunt Cut",
            "description": "Adds structure and sharp lines, contrasting the roundness of the face. The length usually falls below the chin.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 75,
            "name": "Side-Swept Bangs",
            "description": "Adds asymmetry and draws attention to the eyes, creating a slimming effect. The bangs are swept to one side.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 76,
            "name": "Textured Lob",
            "description": "Adds volume and movement, balancing the width of a round face. The waves create a soft and stylish look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 77,
            "name": "Beach Waves",
            "description": "Adds a tousled and relaxed look, breaking up the roundness of the face. The waves create a soft and feminine look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 78,
            "name": "Shaggy Bob",
            "description": "Adds layers and waves for a textured look that balances the width of a round face. The shaggy style creates volume and movement.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 79,
            "name": "Curly Bob",
            "description": "Adds volume and texture, balancing the width of a round face. The curls create a playful and chic look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 80,
            "name": "Curly Shag",
            "description": "Features layers and curls for a voluminous and textured look. This style adds height and breaks up the roundness of the face.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          },
          {
            "id": 81,
            "name": "Long Curly Layers",
            "description": "Adds length and volume, drawing attention away from the width of the face. The curls create a soft and flowing look.",
            "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/1.jpg"
          }
        ]
    """;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ValidateToken({RoleEnum.USER,RoleEnum.ADMIN})
    public ResponseEntity<?> getAllHairstyles() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // replace single quotes with double quotes
        String validJson = HAIRSTYLES_JSON.replace('\'', '\"');

        // parse JSON string into a list of maps
        List<Map<String, Object>> haircutList = objectMapper.readValue(validJson, new TypeReference<List<Map<String, Object>>>() {});

        // shuffle the list to randomize elements order
        Collections.shuffle(haircutList);

        // convert the list back to JSON string
        String shuffledJson = objectMapper.writeValueAsString(haircutList);

        return ResponseEntity.ok(shuffledJson);
    }
}
