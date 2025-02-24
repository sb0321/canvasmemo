package sb.project.common_module.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "memo_tags")
public class MemoTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<Memo> memos;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "id")
    private Collection<Tag> tags;
}
