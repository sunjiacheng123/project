package sun.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class Book extends DictionaryTag{
    private Integer id;
    private String bookName;
    private String author;
    private BigDecimal price;
    private Date createTime;
}
