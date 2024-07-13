select FLAVOR
from
    (select FLAVOR, A.TOTAL_ORDER+B.TOTAL_ORDER as TOTAL_ORDER
    from FIRST_HALF A
    join
        (select FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
        from JULY
        group by FLAVOR) B
    using(FLAVOR)
    order by TOTAL_ORDER desc)
where rownum<=3;



