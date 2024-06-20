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
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/2.jpg"
              },
              {
                "id": 3,
                "name": "Textured Crop",
                "description": "Adds volume and texture, reducing the boxiness of a square face. The hair is cut in short, choppy layers that add movement.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/3.webp"
              },
              {
                "id": 4,
                "name": "Messy Quiff",
                "description": "Adds height and texture, drawing attention upwards. This style is slightly tousled for a casual yet stylish appearance.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/4.jpg"
              },
              {
                "id": 5,
                "name": "Wavy Side Swept",
                "description": "Balances the strong jawline with soft waves. The hair is swept to one side, creating a relaxed and sophisticated look.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/5.jpg"
              },
              {
                "id": 6,
                "name": "Curly Fringe",
                "description": "Softens the angles with natural wave patterns. The fringe is left longer and styled to create a wavy, textured look.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/6.jpg"
              },
              {
                "id": 7,
                "name": "Curly Top with Tapered Sides",
                "description": "Keeps the curls manageable and stylish. The sides are tapered short while the top is left longer to showcase natural curls.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/7.jpg"
              },
              {
                "id": 8,
                "name": "Short Afro",
                "description": "Maintains the natural curl pattern, emphasizing the round shape without overwhelming it. This style keeps the curls tight and neat.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/8.jpg"
              },
              {
                "id": 9,
                "name": "Curly Undercut",
                "description": "Contrasts the tight curls on top with short sides. This style is trendy and highlights the natural curls.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/9.jpg"
              },
              {
                "id": 10,
                "name": "Pompadour",
                "description": "Adds volume on top, balancing the face length. This style is characterized by its height and slicked-back appearance.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/10.jpg"
              },
              {
                "id": 11,
                "name": "Side Part with Fade",
                "description": "Adds width to the face, making it look less elongated. The fade creates a clean contrast between the sides and the longer top.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/11.jpg"
              },
              {
                "id": 12,
                "name": "Buzz Cut",
                "description": "Creates a balanced and uniform look. This ultra-short haircut is easy to maintain and emphasizes facial features.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/12.jpg"
              },
              {
                "id": 13,
                "name": "Wavy Pompadour",
                "description": "Combines volume and texture, ideal for a rectangular face. This style keeps the natural wave while adding height.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/13.jpg"
              },
              {
                "id": 14,
                "name": "Loose Waves with Tapered Sides",
                "description": "Keeps the focus on the hair without elongating the face. The sides are tapered short while the top remains wavy.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/14.jpg"
              },
              {
                "id": 15,
                "name": "Shaggy Layers",
                "description": "Adds width and softens the long face shape. The hair is cut in layers to enhance the natural wave and add volume.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/15.jpg"
              },
              {
                "id": 16,
                "name": "Curly Pompadour",
                "description": "Adds height and dimension without elongating the face. The curls are styled upwards and back.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/16.jpg"
              },
              {
                "id": 17,
                "name": "Medium Length Curls",
                "description": "Provides volume and balance to the face. The curls are left at medium length for a natural, voluminous look.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/17.jpg"
              },
              {
                "id": 18,
                "name": "Curly Fringe with Undercut",
                "description": "Keeps curls manageable and adds width to the face. The undercut contrasts with the curly fringe on top.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/18.jpg"
              },
              {
                "id": 19,
                "name": "Classic Taper",
                "description": "A timeless cut that complements the balanced proportions. The sides are tapered short, and the top is left slightly longer.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/19.jpg"
              },
              {
                "id": 20,
                "name": "Textured Pompadour",
                "description": "Adds volume without elongating the face. The hair is styled upwards and back with added texture.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/20.jpg"
              },
              {
                "id": 21,
                "name": "Crew Cut",
                "description": "Simple and neat, maintaining the natural balance. This short haircut is easy to maintain and suits an oval face well.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/21.jpg"
              },
              {
                "id": 22,
                "name": "Wavy Fringe",
                "description": "Adds texture and keeps the face looking balanced. The fringe is left longer and styled to enhance the natural wave.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/22.webp"
              },
              {
                "id": 23,
                "name": "Tousled Waves",
                "description": "Enhances the natural wave pattern for a casual look. The hair is left at medium length and tousled for texture.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/23.jpg"
              },
              {
                "id": 24,
                "name": "Medium Length Shag",
                "description": "Softens the features and adds texture. The hair is cut in layers to enhance the wave and create a shaggy look.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/24.jpg"
              },
              {
                "id": 25,
                "name": "Curly Caesar Cut",
                "description": "Keeps curls tight and manageable. The hair is cut short with a slight fringe.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/25.webp"
              },
              {
                "id": 26,
                "name": "Curly Quiff",
                "description": "Adds height and texture, complementing the oval shape. The curls are styled upwards and back.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/26.jpg"
              },
              {
                "id": 27,
                "name": "Medium Length Curls with Tapered Sides",
                "description": "Balances the face with volume and control. The sides are tapered short while the curls are left at medium length.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/27.webp"
              },
              {
                "id": 28,
                "name": "Pompadour",
                "description": "Adds volume on top, balancing the face length. This style is characterized by its height and slicked-back appearance.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/28.jpg"
              },
              {
                "id": 29,
                "name": "Side Part with Fade",
                "description": "Adds width to the face, making it look less elongated. The fade creates a clean contrast between the sides and the longer top.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/29.jpg"
              },
              {
                "id": 30,
                "name": "Buzz Cut",
                "description": "Creates a balanced and uniform look. This ultra-short haircut is easy to maintain and emphasizes facial features.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/30.webp"
              },
              {
                "id": 31,
                "name": "Wavy Pompadour",
                "description": "Combines volume and texture, ideal for a rectangular face. This style keeps the natural wave while adding height.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/31.jpg"
              },
              {
                "id": 32,
                "name": "Loose Waves with Tapered Sides",
                "description": "Keeps the focus on the hair without elongating the face. The sides are tapered short while the top remains wavy.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/32.jpg"
              },
              {
                "id": 33,
                "name": "Shaggy Layers",
                "description": "Adds width and softens the long face shape. The hair is cut in layers to enhance the natural wave and add volume.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/33.jpg"
              },
              {
                "id": 34,
                "name": "Curly Pompadour",
                "description": "Adds height and dimension without elongating the face. The curls are styled upwards and back.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/34.png"
              },
              {
                "id": 35,
                "name": "Medium Length Curls",
                "description": "Provides volume and balance to the face. The curls are left at medium length for a natural, voluminous look.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/35.jpg"
              },
              {
                "id": 36,
                "name": "Curly Fringe with Undercut",
                "description": "Keeps curls manageable and adds width to the face. The undercut contrasts with the curly fringe on top.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/36.jpeg"
              },
              {
                "id": 37,
                "name": "Long Layers",
                "description": "Adds softness and movement, reducing the angularity of a square face. The layers create a cascading effect that flatters the jawline.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/37.jpg"
              },
              {
                "id": 38,
                "name": "Blunt Bob",
                "description": "Emphasizes the sharp features of a square face with a sleek and sophisticated look. The length is usually just below the chin, enhancing the jawline.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/38.jpg"
              },
              {
                "id": 39,
                "name": "Side-Swept Bangs",
                "description": "Softens the forehead and adds a touch of asymmetry to balance the square shape. The bangs are swept to one side, creating a gentle frame for the face.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/39.jpg"
              },
              {
                "id": 40,
                "name": "Beach Waves",
                "description": "Adds a soft, tousled look that breaks up the strong lines of a square face. The natural waves create volume and movement.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/40.jpg"
              },
              {
                "id": 41,
                "name": "Shaggy Lob",
                "description": "Combines layers and waves for a textured look that adds dimension and softness to a square face. The lob length falls around the collarbone.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/41.jpg"
              },
              {
                "id": 42,
                "name": "Wavy Pixie Cut",
                "description": "Adds a playful and chic element to the square face. The waves create a soft texture that contrasts with the structured shape.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/42.jpg"
              },
              {
                "id": 43,
                "name": "Curly Bob",
                "description": "The curls add volume and texture, softening the angles of a square face. The bob length enhances the jawline while adding movement.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/43.jpg"
              },
              {
                "id": 44,
                "name": "Curly Shag",
                "description": "Features layers and curls for a voluminous and textured look. This style breaks up the strong lines of a square face, adding softness.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/44.jpeg"
              },
              {
                "id": 45,
                "name": "Long Curly Layers",
                "description": "Adds length and volume, drawing attention away from the jawline. The curls create a soft and romantic look.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/45.jpg"
              },
              {
                "id": 46,
                "name": "Long Layers with Side Part",
                "description": "Adds volume at the bottom to balance the wider forehead and narrower chin. The side part softens the forehead.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/46.jpg"
              },
              {
                "id": 47,
                "name": "Chin-Length Bob",
                "description": "Balances the face shape by adding volume around the chin area. This length is perfect for highlighting the jawline.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/47.jpg"
              },
              {
                "id": 48,
                "name": "Curtain Bangs",
                "description": "Softens the forehead and draws attention to the eyes. The bangs part in the middle and frame the face nicely.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/48.jpg"
              },
              {
                "id": 49,
                "name": "Textured Lob",
                "description": "Adds body and movement, softening the chin and balancing the forehead. The waves create a relaxed and stylish look.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/49.jpg"
              },
              {
                "id": 50,
                "name": "Wavy Bob with Bangs",
                "description": "Adds volume around the chin and softens the forehead with bangs. The waves add texture and dimension.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/50.jpg"
              },
              {
                "id": 51,
                "name": "Boho Waves",
                "description": "Creates a soft, tousled look that balances the heart-shaped face. The waves add a carefree and feminine touch.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/51.jpg"
              },
              {
                "id": 52,
                "name": "Curly Bob",
                "description": "Adds volume and balances the face by drawing attention away from the forehead. The curls create a playful and chic look.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/52.jpg"
              },
              {
                "id": 53,
                "name": "Curly Lob",
                "description": "Adds length and volume, creating a balanced look. The curls enhance the overall volume and add a fun texture.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/53.jpg"
              },
              {
                "id": 54,
                "name": "Curly Pixie",
                "description": "Highlights the natural curl pattern and creates a voluminous top, balancing the face shape. The sides are kept short for contrast.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/54.jpg"
              },
              {
                "id": 55,
                "name": "Blunt Bob",
                "description": "A classic bob that is even all around, accentuating the symmetry of an oval face.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/55.jpg"
              },
              {
                "id": 56,
                "name": "Long, Sleek Hair",
                "description": "Straight and smooth hair that falls past the shoulders, emphasizing the faces natural shape.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/56.jpg"
              },
              {
                "id": 57,
                "name": "Curtain Bangs",
                "description": "Bangs parted down the middle or to the sides, framing the face softly.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/57.jpeg"
              },
              {
                "id": 58,
                "name": "Long Waves",
                "description": "Soft waves that start from the mid-lengths, adding volume without overwhelming the face.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/58.jpg"
              },
              {
                "id": 59,
                "name": "Textured Lob",
                "description": "A long bob with textured ends, giving a modern, effortless look.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/59.webp"
              },
              {
                "id": 60,
                "name": "Side-parted Waves",
                "description": "Waves parted to one side, adding volume and highlighting the cheekbones.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/60.jpg"
              },
              {
                "id": 61,
                "name": "Curly Bob",
                "description": "The curls add volume and texture, softening the angles of a square face. The bob length enhances the jawline while adding movement.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/61.jpg"
              },
              {
                "id": 62,
                "name": "Layered Curls",
                "description": "Layers throughout the hair to manage volume and enhance the natural curl pattern.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/62.jpg"
              },
              {
                "id": 63,
                "name": "Curly Fringe",
                "description": "Curly bangs that frame the face, adding a playful and trendy touch.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/63.jpg"
              },
              {
                "id": 64,
                "name": "Chin-length Bob",
                "description": "A bob that stops at the chin, shortening the faces appearance.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/64.webp"
              },
              {
                "id": 65,
                "name": "Blunt Bangs",
                "description": "Shortens the appearance of an oblong face by covering the forehead. Blunt bangs add a chic and youthful touch.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/65.jpg"
              },
              {
                "id": 66,
                "name": "Layered Shoulder-length Hair",
                "description": "Layers around the shoulders to add volume and width to the face.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/66.jpg"
              },
              {
                "id": 67,
                "name": "Choppy Lob",
                "description": "A shoulder-length cut with choppy layers for added texture and width.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/67.webp"
              },
              {
                "id": 68,
                "name": "Loose Waves with Bangs",
                "description": "Waves that start from the mid-lengths and blunt bangs to create balance.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/68.jpg"
              },
              {
                "id": 69,
                "name": "Medium-length Waves",
                "description": "Waves that fall around the shoulders, adding softness and width.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/69.webp"
              },
              {
                "id": 70,
                "name": "Curly Bob with Bangs",
                "description": "A short, curly bob with bangs to shorten the face and add volume.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/70.jpg"
              },
              {
                "id": 71,
                "name": "Full Curls",
                "description": "Voluminous curls that add width and shorten the faces length.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/71.jpg"
              },
              {
                "id": 72,
                "name": "Layered Curls",
                "description": "ayers to manage volume and enhance the natural shape, creating balance.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/72.jpeg"
              },
              {
                "id": 73,
                "name": "Long Layers",
                "description": "Layers that start below the chin to elongate the face.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/73.webp"
              },
              {
                "id": 74,
                "name": "Side-parted Straight Hair",
                "description": "A deep side part to create asymmetry and lengthen the face.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/74.jpg"
              },
              {
                "id": 75,
                "name": "Straight Lob",
                "description": "A long bob that hits just above the shoulders to add length.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/75.jpg"
              },
              {
                "id": 76,
                "name": "Beach Waves",
                "description": "Loose waves that start from the mid-lengths, adding height and elongating the face.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/76.jpg"
              },
              {
                "id": 77,
                "name": "Layered Waves",
                "description": "Layers throughout the hair to create movement and reduce roundness.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/77.webp"
              },
              {
                "id": 78,
                "name": "Side-swept Waves",
                "description": "Waves swept to one side to create an illusion of length.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/78.webp"
              },
              {
                "id": 79,
                "name": "Curly Bob",
                "description": "A bob with curls that add volume and structure without overwhelming the face.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/79.jpg"
              },
              {
                "id": 80,
                "name": "Voluminous Curls",
                "description": "Big, loose curls that add height and elongate the face.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/80.jpg"
              },
              {
                "id": 81,
                "name": "Layered Curls",
                "description": "Layers to reduce bulk and add dimension, elongating the face.",
                "photo_url": "https://storage.googleapis.com/shavemax/hairstyles/81.jpeg"
              }
            ]
                """;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ValidateToken({ RoleEnum.USER, RoleEnum.ADMIN })
    public ResponseEntity<?> getAllHairstyles() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // replace single quotes with double quotes
         String validJson = HAIRSTYLES_JSON.replace('\'', '\"');

        // parse JSON string into a list of maps
        List<Map<String, Object>> haircutList = objectMapper.readValue(validJson,
                new TypeReference<List<Map<String, Object>>>() {
                });

        // shuffle the list to randomize elements order
        Collections.shuffle(haircutList);

        // convert the list back to JSON string
        String shuffledJson = objectMapper.writeValueAsString(haircutList);

        return ResponseEntity.ok(shuffledJson);
    }
}
