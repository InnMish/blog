import {Comment} from "../../comments/_models/comment.model";
import {Paragraph} from "../../paragraphs/_models/paragraph.model";
import {Category} from "../../categories/_models/category.model";

export interface Article {
  articleId: number;
  title: string;
  description?: string;

  comments?: Comment[];
  paragraphs: Paragraph[];
  category: Category;
}
