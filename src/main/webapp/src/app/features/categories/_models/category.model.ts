import {Article} from "../../articles/_models/article.model";

export interface Category {
  categoryId: number;
  title: string;
  articles?: Article[];
}
