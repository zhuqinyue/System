//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.entity;

import com.company.system.entity.Author;
import com.company.system.entity.Question;
import java.util.List;

public class Target {
    private long created_time;
    private String image_url;
    private long updated;
    private Boolean is_labeled;
    private String excerpt;
    private long id;
    private List<String> topic_thumbnails;
    private Author author;
    private String url;
    private String title;
    private long created;
    private String content;
    private int comment_count;
    private String excerpt_title;
    private int voteup_count;
    private String type;
    private Question question;
    private String updated_time;
    private String thumbnail;

    public Target() {
    }

    public long getCreated_time() {
        return this.created_time;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public long getUpdated() {
        return this.updated;
    }

    public Boolean getIs_labeled() {
        return this.is_labeled;
    }

    public String getExcerpt() {
        return this.excerpt;
    }

    public long getId() {
        return this.id;
    }

    public List<String> getTopic_thumbnails() {
        return this.topic_thumbnails;
    }

    public Author getAuthor() {
        return this.author;
    }

    public String getUrl() {
        return this.url;
    }

    public String getTitle() {
        return this.title;
    }

    public long getCreated() {
        return this.created;
    }

    public String getContent() {
        return this.content;
    }

    public int getComment_count() {
        return this.comment_count;
    }

    public String getExcerpt_title() {
        return this.excerpt_title;
    }

    public int getVoteup_count() {
        return this.voteup_count;
    }

    public String getType() {
        return this.type;
    }

    public Question getQuestion() {
        return this.question;
    }

    public String getUpdated_time() {
        return this.updated_time;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setCreated_time(long created_time) {
        this.created_time = created_time;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public void setIs_labeled(Boolean is_labeled) {
        this.is_labeled = is_labeled;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTopic_thumbnails(List<String> topic_thumbnails) {
        this.topic_thumbnails = topic_thumbnails;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public void setExcerpt_title(String excerpt_title) {
        this.excerpt_title = excerpt_title;
    }

    public void setVoteup_count(int voteup_count) {
        this.voteup_count = voteup_count;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setUpdated_time(String updated_time) {
        this.updated_time = updated_time;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof Target)) {
            return false;
        } else {
            Target other = (Target)o;
            if(!other.canEqual(this)) {
                return false;
            } else if(this.getCreated_time() != other.getCreated_time()) {
                return false;
            } else {
                label189: {
                    String this$image_url = this.getImage_url();
                    String other$image_url = other.getImage_url();
                    if(this$image_url == null) {
                        if(other$image_url == null) {
                            break label189;
                        }
                    } else if(this$image_url.equals(other$image_url)) {
                        break label189;
                    }

                    return false;
                }

                if(this.getUpdated() != other.getUpdated()) {
                    return false;
                } else {
                    Boolean this$is_labeled = this.getIs_labeled();
                    Boolean other$is_labeled = other.getIs_labeled();
                    if(this$is_labeled == null) {
                        if(other$is_labeled != null) {
                            return false;
                        }
                    } else if(!this$is_labeled.equals(other$is_labeled)) {
                        return false;
                    }

                    label174: {
                        String this$excerpt = this.getExcerpt();
                        String other$excerpt = other.getExcerpt();
                        if(this$excerpt == null) {
                            if(other$excerpt == null) {
                                break label174;
                            }
                        } else if(this$excerpt.equals(other$excerpt)) {
                            break label174;
                        }

                        return false;
                    }

                    if(this.getId() != other.getId()) {
                        return false;
                    } else {
                        List this$topic_thumbnails = this.getTopic_thumbnails();
                        List other$topic_thumbnails = other.getTopic_thumbnails();
                        if(this$topic_thumbnails == null) {
                            if(other$topic_thumbnails != null) {
                                return false;
                            }
                        } else if(!this$topic_thumbnails.equals(other$topic_thumbnails)) {
                            return false;
                        }

                        Author this$author = this.getAuthor();
                        Author other$author = other.getAuthor();
                        if(this$author == null) {
                            if(other$author != null) {
                                return false;
                            }
                        } else if(!this$author.equals(other$author)) {
                            return false;
                        }

                        label152: {
                            String this$url = this.getUrl();
                            String other$url = other.getUrl();
                            if(this$url == null) {
                                if(other$url == null) {
                                    break label152;
                                }
                            } else if(this$url.equals(other$url)) {
                                break label152;
                            }

                            return false;
                        }

                        label145: {
                            String this$title = this.getTitle();
                            String other$title = other.getTitle();
                            if(this$title == null) {
                                if(other$title == null) {
                                    break label145;
                                }
                            } else if(this$title.equals(other$title)) {
                                break label145;
                            }

                            return false;
                        }

                        if(this.getCreated() != other.getCreated()) {
                            return false;
                        } else {
                            label137: {
                                String this$content = this.getContent();
                                String other$content = other.getContent();
                                if(this$content == null) {
                                    if(other$content == null) {
                                        break label137;
                                    }
                                } else if(this$content.equals(other$content)) {
                                    break label137;
                                }

                                return false;
                            }

                            if(this.getComment_count() != other.getComment_count()) {
                                return false;
                            } else {
                                label129: {
                                    String this$excerpt_title = this.getExcerpt_title();
                                    String other$excerpt_title = other.getExcerpt_title();
                                    if(this$excerpt_title == null) {
                                        if(other$excerpt_title == null) {
                                            break label129;
                                        }
                                    } else if(this$excerpt_title.equals(other$excerpt_title)) {
                                        break label129;
                                    }

                                    return false;
                                }

                                if(this.getVoteup_count() != other.getVoteup_count()) {
                                    return false;
                                } else {
                                    label121: {
                                        String this$type = this.getType();
                                        String other$type = other.getType();
                                        if(this$type == null) {
                                            if(other$type == null) {
                                                break label121;
                                            }
                                        } else if(this$type.equals(other$type)) {
                                            break label121;
                                        }

                                        return false;
                                    }

                                    Question this$question = this.getQuestion();
                                    Question other$question = other.getQuestion();
                                    if(this$question == null) {
                                        if(other$question != null) {
                                            return false;
                                        }
                                    } else if(!this$question.equals(other$question)) {
                                        return false;
                                    }

                                    label107: {
                                        String this$updated_time = this.getUpdated_time();
                                        String other$updated_time = other.getUpdated_time();
                                        if(this$updated_time == null) {
                                            if(other$updated_time == null) {
                                                break label107;
                                            }
                                        } else if(this$updated_time.equals(other$updated_time)) {
                                            break label107;
                                        }

                                        return false;
                                    }

                                    String this$thumbnail = this.getThumbnail();
                                    String other$thumbnail = other.getThumbnail();
                                    if(this$thumbnail == null) {
                                        if(other$thumbnail != null) {
                                            return false;
                                        }
                                    } else if(!this$thumbnail.equals(other$thumbnail)) {
                                        return false;
                                    }

                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Target;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        long $created_time = this.getCreated_time();
        int result1 = result * 59 + (int)($created_time >>> 32 ^ $created_time);
        String $image_url = this.getImage_url();
        result1 = result1 * 59 + ($image_url == null?43:$image_url.hashCode());
        long $updated = this.getUpdated();
        result1 = result1 * 59 + (int)($updated >>> 32 ^ $updated);
        Boolean $is_labeled = this.getIs_labeled();
        result1 = result1 * 59 + ($is_labeled == null?43:$is_labeled.hashCode());
        String $excerpt = this.getExcerpt();
        result1 = result1 * 59 + ($excerpt == null?43:$excerpt.hashCode());
        long $id = this.getId();
        result1 = result1 * 59 + (int)($id >>> 32 ^ $id);
        List $topic_thumbnails = this.getTopic_thumbnails();
        result1 = result1 * 59 + ($topic_thumbnails == null?43:$topic_thumbnails.hashCode());
        Author $author = this.getAuthor();
        result1 = result1 * 59 + ($author == null?43:$author.hashCode());
        String $url = this.getUrl();
        result1 = result1 * 59 + ($url == null?43:$url.hashCode());
        String $title = this.getTitle();
        result1 = result1 * 59 + ($title == null?43:$title.hashCode());
        long $created = this.getCreated();
        result1 = result1 * 59 + (int)($created >>> 32 ^ $created);
        String $content = this.getContent();
        result1 = result1 * 59 + ($content == null?43:$content.hashCode());
        result1 = result1 * 59 + this.getComment_count();
        String $excerpt_title = this.getExcerpt_title();
        result1 = result1 * 59 + ($excerpt_title == null?43:$excerpt_title.hashCode());
        result1 = result1 * 59 + this.getVoteup_count();
        String $type = this.getType();
        result1 = result1 * 59 + ($type == null?43:$type.hashCode());
        Question $question = this.getQuestion();
        result1 = result1 * 59 + ($question == null?43:$question.hashCode());
        String $updated_time = this.getUpdated_time();
        result1 = result1 * 59 + ($updated_time == null?43:$updated_time.hashCode());
        String $thumbnail = this.getThumbnail();
        result1 = result1 * 59 + ($thumbnail == null?43:$thumbnail.hashCode());
        return result1;
    }

    public String toString() {
        return "Target(created_time=" + this.getCreated_time() + ", image_url=" + this.getImage_url() + ", updated=" + this.getUpdated() + ", is_labeled=" + this.getIs_labeled() + ", excerpt=" + this.getExcerpt() + ", id=" + this.getId() + ", topic_thumbnails=" + this.getTopic_thumbnails() + ", author=" + this.getAuthor() + ", url=" + this.getUrl() + ", title=" + this.getTitle() + ", created=" + this.getCreated() + ", content=" + this.getContent() + ", comment_count=" + this.getComment_count() + ", excerpt_title=" + this.getExcerpt_title() + ", voteup_count=" + this.getVoteup_count() + ", type=" + this.getType() + ", question=" + this.getQuestion() + ", updated_time=" + this.getUpdated_time() + ", thumbnail=" + this.getThumbnail() + ")";
    }
}
