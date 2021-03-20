create keyspace if not exists tesseract with replication = {'class': 'SimpleStrategy', 'replication_factor': 1};
use tesseract;


/*
    Moment Table will contain the basic information
 */
create table if not exists remembrance
(
    remembrance_id uuid,
    name           text,
    description    text,
    created        timestamp,
    updated        timestamp,
    PRIMARY KEY ( remembrance_id )
);

/*
    This table will contain a remembrance detail:
    - links
    - images
    - keywords
    - start time
    - end time
 */
create table if not exists moment
(
    remembrance_id   uuid,
    moment_id        timeuuid,
    link             text,
    images           text,
    keywords         list<text>,
    start_time       int,
    end_time         int,
    category         text,
    art_of_work_name text,
    PRIMARY KEY (remembrance_id, moment_id)
);

/*
    Moments by category
 */
create table if not exists moments_by_category
(
    category  text,
    moment_id uuid,
    PRIMARY KEY (category, moment_id)
);

