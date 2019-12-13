package com.organizationX.cu.domain.people

import javax.persistence.*

@Entity
@Table(name = "PEOPLE")
class People(_id: Long,
            _name: String? = null,
            _age: Int = 0
             ){

    /*************************************************
     * Fields                                        *
     ************************************************/
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PEOP_SEQ_PEOPLE_ID")
    @SequenceGenerator(name = "PEOP_SEQ_PEOPLE_ID", sequenceName = "PEOP_SEQ_PEOPLE_ID",
                       allocationSize = 1)
    @Id
    @Column(name = "PEOP_PK_PEOPLE_ID")
    var id: Long = _id
        private set


    //todo: alterar o nome na coluna do bd
    @Column(name = "PEOP_CH_PEOPLE_NAME")
    var name: String? = _name

    @Column(name = "PEOP_NU_PEOPLE_AGE")
    var age:Int = _age

}