package model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Category extends BaseModel {
    private String categoryName;
    private Item [] items;
}
