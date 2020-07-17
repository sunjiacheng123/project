package sun.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Page {
    private String searchText;
    private String sortOrder;
    private Integer pageSize;
    private Integer pageNumber;



}
